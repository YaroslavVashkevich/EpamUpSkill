package com.epam.rd.autocode.factory.plot;

public class MarvelFactory implements PlotFactory {
    private Character[] heroes;
    private EpicCrisis epicCrisis;
    private Character villain;


    public MarvelFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public Plot plot() {
        Plot plot = new ListPlots("");
        if (compare(heroes, new Character[]{() -> "Iron Man"}) && epicCrisis.name() == "Ten Rings is about to access Stark Industries technologies and that" && villain.name() == "Obadiah Stane") {
            plot = new ListPlots(Plots.IRON_MAN);
        }
        if (compare(heroes, new Character[]{() -> "Iron Man", () -> "Captain America", () -> "Hulk", () -> "Thor", () -> "Black Widow", () -> "HawkEye"}) && epicCrisis.name() == "Chitauri Invasion" && villain.name() == "Loki") {
            plot = new ListPlots(Plots.CAPTAIN_AMERICA);
        }
        if (compare(heroes, new Character[]{() -> "Star-Lord", () -> "Gamora", () -> "Drax", () -> "Groot", () -> "Rocket"}) && epicCrisis.name() == "Kree Invasion" && villain.name() == "Ronan the Accuser") {
            plot = new ListPlots(Plots.STAR_LORD);
        }
        return plot;

    }

    public boolean compare(Character[] a, Character[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].name() != b[i].name())
                return false;
        }
        return true;
    }
}
