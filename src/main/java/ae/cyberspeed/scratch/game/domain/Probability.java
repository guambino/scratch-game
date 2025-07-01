package ae.cyberspeed.scratch.game.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;
import java.util.Objects;

public class Probability {

    @JsonAlias("standard_symbols")
    private List<StandardSymbol> standardSymbols;

    @JsonAlias("bonus_symbols")
    private BonusSymbol bonusSymbol;

    public List<StandardSymbol> getStandardSymbols() {
        return standardSymbols;
    }

    public void setStandardSymbols(List<StandardSymbol> standardSymbols) {
        this.standardSymbols = standardSymbols;
    }

    public BonusSymbol getBonusSymbol() {
        return bonusSymbol;
    }

    public void setBonusSymbol(BonusSymbol bonusSymbol) {
        this.bonusSymbol = bonusSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Objects.equals(standardSymbols, that.standardSymbols) && Objects.equals(bonusSymbol, that.bonusSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(standardSymbols, bonusSymbol);
    }

    @Override
    public String toString() {
        return "Probability{" +
                "standardSymbols=" + standardSymbols +
                ", bonusSymbol=" + bonusSymbol +
                '}';
    }
}
