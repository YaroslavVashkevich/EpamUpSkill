package com.epam.rd.autocode.floodfill;

public class FloodFillImpl implements FloodFill {

    @Override
    public void flood(String map, FloodLogger logger) {

        String[] rows = map.split("\n");
        char[][] matrix = new char[rows.length][];
        int number = 0;
        for (String row : rows) {
            char[] array = row.toCharArray();
            matrix[number++] = array;
        }
        if (!check(matrix)) {
            logger.log(backArrayToString(matrix));
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == WATER) {
                        if (i != 0 && matrix[i - 1][j] == LAND) {
                            matrix[i - 1][j] = '0';
                        }
                        if (i != matrix.length - 1 && matrix[i + 1][j] == LAND) {
                            matrix[i + 1][j] = '0';
                        }
                        if (j != matrix[i].length - 1 && matrix[i][j + 1] == LAND) {
                            matrix[i][j + 1] = '0';
                        }
                        if (j != 0 && matrix[i][j - 1] == LAND) {
                            matrix[i][j - 1] = '0';
                        }
                    }
                }
            }
            flood(backArrayToString(intermediate(matrix)), logger);
        } else {
            logger.log(backArrayToString(matrix));
        }
    }

    public String backArrayToString(char[][] matrix) {
        String back = "";
        for (int i = 0; i < matrix.length; i++) {
            back = back + String.valueOf(matrix[i]) + "\n";
        }
        return back.substring(0, back.length() - 1);
    }

    public char[][] intermediate(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    matrix[i][j] = WATER;
                }
            }
        }
        return matrix;
    }

    public boolean check(char[][] matrix) {
        int countWater = 0;
        int countAll = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                countAll++;
                if (matrix[i][j] == WATER) {
                    countWater++;
                }
            }
        }
        if (countAll == countWater) {
            return true;
        }
        return false;
    }
}
