package ae.cyberspeed.scratch.game.domain;

import java.util.Map;
import java.util.Objects;

public class Configuration {

    private int columns;

    private int rows;

    private Map<String, Symbol> symbols;

    private Probability probabilities;

    private Map<String, WinCombination> winCombinations;

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(Map<String, Symbol> symbols) {
        this.symbols = symbols;
    }

    public Probability getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(Probability probabilities) {
        this.probabilities = probabilities;
    }

    public Map<String, WinCombination> getWinCombinations() {
        return winCombinations;
    }

    public void setWinCombinations(Map<String, WinCombination> winCombinations) {
        this.winCombinations = winCombinations;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return columns == that.columns && rows == that.rows && Objects.equals(symbols, that.symbols) && Objects.equals(probabilities, that.probabilities) && Objects.equals(winCombinations, that.winCombinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columns, rows, symbols, probabilities, winCombinations);
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "columns=" + columns +
                ", rows=" + rows +
                ", symbols=" + symbols +
                ", probabilities=" + probabilities +
                ", winCombinations=" + winCombinations +
                '}';
    }
}
