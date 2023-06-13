package com.epam.rd.autocode.factory.plot;

public class ContemporaryDisneyFactory implements PlotFactory {
    private Character hero;
    private EpicCrisis epicCrisis;
    private Character funnyFriend;


    public ContemporaryDisneyFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.funnyFriend = funnyFriend;
    }

    @Override
    public Plot plot() {
        Plot plot = new ListPlots("");
        if (hero.name() == "Mulan" && epicCrisis.name() == "Hun invasion" && funnyFriend.name() == "little dragon Mushu") {
            plot = new ListPlots(Plots.MULAN);
        }
        if (hero.name() == "Anna" && epicCrisis.name() == "her sister Elsa is overwhelmed by her magical powers" && funnyFriend.name() == "snowman Olaf") {
            plot = new ListPlots(Plots.ANNA);
        }
        if (hero.name() == "Moana" && epicCrisis.name() == "a blight strikes the island" && funnyFriend.name() == "shape-shifting demigod Maui") {
            plot = new ListPlots(Plots.MOANA);
        }
        return plot;
    }
}
