package ae.cyberspeed.scratch.game.domain;

import java.util.Objects;

public class Symbol {

    private Double rewardMultiplier;

    private String type;

    private Integer extra;

    private String impact;

    public Double getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(Double rewardMultiplier) {
        this.rewardMultiplier = rewardMultiplier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getExtra() {
        return extra;
    }

    public void setExtra(Integer extra) {
        this.extra = extra;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return Objects.equals(rewardMultiplier, symbol.rewardMultiplier) && Objects.equals(type, symbol.type) && Objects.equals(extra, symbol.extra) && Objects.equals(impact, symbol.impact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardMultiplier, type, extra, impact);
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "rewardMultiplier=" + rewardMultiplier +
                ", type='" + type + '\'' +
                ", extra=" + extra +
                ", impact='" + impact + '\'' +
                '}';
    }
}
