package ae.cyberspeed.scratch.game.domain;

import java.util.List;
import java.util.Objects;

public class WinCombination {

    private Double rewardMultiplier;

    private String when;

    private Integer count;

    private String group;

    private List<List<String>> coveredAreas;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WinCombination that = (WinCombination) o;
        return Objects.equals(rewardMultiplier, that.rewardMultiplier) && Objects.equals(when, that.when) && Objects.equals(count, that.count) && Objects.equals(group, that.group) && Objects.equals(coveredAreas, that.coveredAreas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardMultiplier, when, count, group, coveredAreas);
    }

    @Override
    public String toString() {
        return "WinCombination{" +
                "rewardMultiplier=" + rewardMultiplier +
                ", when='" + when + '\'' +
                ", count=" + count +
                ", group='" + group + '\'' +
                ", coveredAreas=" + coveredAreas +
                '}';
    }
}
