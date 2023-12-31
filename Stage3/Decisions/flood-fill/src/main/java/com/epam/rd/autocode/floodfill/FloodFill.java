package com.epam.rd.autocode.floodfill;

public interface FloodFill {
    void flood(final String map, final FloodLogger logger);

    static FloodFill getInstance() {
        FloodFill fl = new FloodFillImpl();
        return fl;
    }

    char LAND = '█';
    char WATER = '░';
}
