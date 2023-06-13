package com.epam.rd.autocode.factory.plot;

public class ClassicDisneyFactory implements PlotFactory {
    private Character hero;
    private Character beloved;
    private Character villain;

    public ClassicDisneyFactory(Character hero, Character beloved, Character villain) {
        this.hero = hero;
        this.beloved = beloved;
        this.villain = villain;
    }

    @Override
    public Plot plot() {
        Plot plot = new ListPlots("");
        if (hero.name() == "Ariel" && beloved.name() == "Eric" && villain.name() == "Ursula") {
            plot = new ListPlots(Plots.ARIEL);
        }
        if (hero.name() == "Belle" && beloved.name() == "Beast" && villain.name() == "Gaston") {
            plot = new ListPlots(Plots.BELLE);
        }
        if (hero.name() == "Simba" && beloved.name() == "Nala" && villain.name() == "Scar") {
            plot = new ListPlots(Plots.SIMBA);
        }
        return plot;
    }
}