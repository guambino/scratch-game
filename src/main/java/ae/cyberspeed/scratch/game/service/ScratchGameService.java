package ae.cyberspeed.scratch.game.service;

import ae.cyberspeed.scratch.game.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.*;

public class ScratchGameService {

    private final Configuration configuration;

    public ScratchGameService(Configuration configuration) {
        this.configuration = configuration;
    }

    public String runGame(Integer bettingAmount){
        int rows = configuration.getRows();
        int cols = configuration.getColumns();

        String[][] matrix = new String[rows][cols];
        Map<String, Integer> symbolCount = new HashMap<>();
        Map<String, List<String>> appliedWins = new HashMap<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String symbol = getRandomSymbol(row, col);
                matrix[row][col] = symbol;
                symbolCount.put(symbol, symbolCount.getOrDefault(symbol, 0) + 1);
            }
        }

        double totalReward = 0;
        for (String key : symbolCount.keySet()){
            Symbol symbol = configuration.getSymbols().get(key);
            if (symbol == null || !"standard".equals(symbol.getType())) {continue;}

            double base = bettingAmount * symbol.getRewardMultiplier();
            double multiplier = 1;

            for (Map.Entry<String, WinCombination> entry : configuration.getWinCombinations().entrySet()) {
                WinCombination wc = entry.getValue();
                if (!wc.getWhen().equals("same_symbols")) continue;
                if (symbolCount.get(key) >= wc.getCount()) {
                    multiplier *= wc.getRewardMultiplier();
                    appliedWins.computeIfAbsent(key, k -> new ArrayList<>()).add(entry.getKey());
                }
            }

            totalReward += base * multiplier;

        }

        for (Map.Entry<String, WinCombination> entry : configuration.getWinCombinations().entrySet()) {
            WinCombination wc = entry.getValue();
            if (!"linear_symbols".equals(wc.getWhen())) {continue;}

            for (List<String> area : wc.getCoveredAreas()) {
                String firstSymbol = null;
                boolean match = true;

                for (String pos : area) {
                    String[] parts = pos.split(":");
                     String  symbol = matrix[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])];
                    if (firstSymbol == null) {
                        firstSymbol = symbol;
                    } else if (!firstSymbol.equals(symbol)) {
                        match = false;
                        break;
                    }
                }

                if (match && configuration.getSymbols().get(firstSymbol).getType().equals("standard")) {
                    double base = bettingAmount * configuration.getSymbols().get(firstSymbol).getRewardMultiplier();
                    totalReward += base * (wc.getRewardMultiplier() - 1);
                    appliedWins.computeIfAbsent(firstSymbol, k -> new ArrayList<>()).add(entry.getKey());
                }
            }
        }

        // Apply bonus if there's a win
        String appliedBonus = null;
        if (totalReward > 0) {
            appliedBonus = getRandomBonus();
            Symbol bonusDef = configuration.getSymbols().get(appliedBonus);
            if ("multiply_reward".equals(bonusDef.getImpact())) {
                totalReward *= bonusDef.getRewardMultiplier();
            } else if ("extra_bonus".equals(bonusDef.getImpact())) {
                totalReward += bonusDef.getExtra();
            }
        }

        // Build JSON output
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        ArrayNode mat = mapper.createArrayNode();
        for (String[] row : matrix) {
            ArrayNode r = mapper.createArrayNode();
            for (String cell : row) r.add(cell);
            mat.add(r);
        }
        root.set("matrix", mat);
        root.put("reward", (int) totalReward);
        ObjectNode winMap = mapper.createObjectNode();
        for (Map.Entry<String, List<String>> e : appliedWins.entrySet()) {
            ArrayNode a = mapper.createArrayNode();
            e.getValue().forEach(a::add);
            winMap.set(e.getKey(), a);
        }
        root.set("applied_winning_combinations", winMap);
        root.put("applied_bonus_symbol", appliedBonus);

        return root.toPrettyString();
    }

    private String getRandomSymbol(int row, int col) {
        for (StandardSymbol standardSymbol : configuration.getProbabilities().getStandardSymbols()) {
            if (standardSymbol.getRow() == row && standardSymbol.getColumn() == col) {
                return weightedRandom(standardSymbol.getSymbols());
            }
        }
        return weightedRandom(configuration.getProbabilities().getStandardSymbols().get(0).getSymbols());

    }

    private String getRandomBonus() {
        return weightedRandom(configuration.getProbabilities().getBonusSymbol().getSymbols());
    }

    private String weightedRandom(Map<String, Integer> weights) {
        int total = weights.values().stream().mapToInt(i -> i).sum();
        int rand = new Random().nextInt(total);
        int cumulative = 0;
        for (Map.Entry<String, Integer> entry : weights.entrySet()) {
            cumulative += entry.getValue();
            if (rand < cumulative){ return entry.getKey();}
        }
        return null;
    }


}
