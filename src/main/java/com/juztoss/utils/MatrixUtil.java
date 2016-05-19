package com.juztoss.utils;

/**
 * Created by Kirill on 5/16/2016.
 */
public class MatrixUtil {


    public static boolean[][] transpose(boolean[][] m) {
        boolean[][] result = new boolean[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                result[j][i] = m[i][j];
        return result;
    }

    public static boolean[][] rotateRight(boolean[][] m) {
        boolean result[][] = transpose(m);
        for (int y = 0; y < result.length; y++) {
            boolean[] row = result[y];
            for (int x = 0; x < row.length / 2; x++) {
                boolean buffer = row[x];
                row[x] = row[row.length - x - 1];
                row[row.length - x - 1] = buffer;
            }
        }

        return result;
    }

    public static boolean[][] rotateLeft(boolean[][] m) {
        boolean result[][] = transpose(m);
        int width = result[0].length;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < result.length / 2; y++) {
                boolean buffer = result[y][x];
                result[y][x] = result[result.length - y - 1][x];
                result[result.length - y - 1][x] = buffer;
            }
        }

        return result;
    }
}
