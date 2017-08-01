package home.task4;

import java.util.Random;

public abstract class ABattle<T> implements IMethods {

    private final int[][] GRID;

    protected ABattle() {
        GRID = new int[M][N];
    }

    protected ABattle(int m, int n) {
        GRID = new int[m][n];
    }

    protected ABattle(String string) {
        GRID = new int[][]{
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
        };
    }

    // init array data - general method
    public synchronized int[][] initGrid(int[][] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(2);
            }
        }
        return array;
    }

    // draw array - general method
    public synchronized void drawGrid(int[][] array) {
        for (int[] element : array) {
            for (int atom : element) {
                System.out.print(atom + " ");
            }
            System.out.println();
        }
    }

    // Check for 1 in current array - general method
    public Boolean isAlive(int[][] array) {
        for (int[] element : array) {
            for (int atom : element) {
                if (atom == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public synchronized int[][] getGRID() {
        return GRID;
    }
    //Realized method in the class SeaBattle.java
    public abstract T getBattle(String i, String j) throws Throwable;

    public abstract T modifyGrid(int[][] array);

    public abstract T sortGrid(int[][] array);

    public abstract T checkGrid(int[][] array);

}