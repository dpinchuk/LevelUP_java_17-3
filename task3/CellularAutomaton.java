package home.task3;

/**
 * Created by Дмитрий on 01.07.2017.
 */
import java.util.Random;

public class CellularAutomaton implements ICell {

    private final int[][] GRID;
    private boolean isLife = true;
    private boolean isTest;
    // constructor with specific values of grid bounds (m, n)
    CellularAutomaton(int m, int n) {
        this.GRID = new int[m][n];
    }
    // constructor with default data
    CellularAutomaton() {
        this.GRID = new int[M][N];
    }
    // constructor with test data
    CellularAutomaton(String string) {
        System.out.println("Test");
        this.GRID = new int[][]{
                {1, 0, 0, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {1, 1, 0, 0, 1}
        };
        isTest = true;
    }
    // init new data for grid array
    public int[][] initGrid() {
        if (!isTest) {
            Random random = new Random();
            for (int i = 0; i < this.GRID.length; i++) {
                for (int j = 0; j < this.GRID[i].length; j++) {
                    this.GRID[i][j] = random.nextInt(2);
                }
            }
        }
        return this.GRID;
    }
    // finding Neighbors for the cell
    private int getNeighbors(int i, int j) {
        return  this.GRID[getIJ(i, this.GRID.length)][getIJ(j - 1, this.GRID[i].length)] +
                this.GRID[getIJ(i, this.GRID.length)][getIJ(j + 1, this.GRID[i].length)] +
                this.GRID[getIJ(i - 1, this.GRID.length)][getIJ(j, this.GRID[i].length)] +
                this.GRID[getIJ(i + 1, this.GRID.length)][getIJ(j, this.GRID[i].length)] +
                this.GRID[getIJ(i - 1, this.GRID.length)][getIJ(j - 1, this.GRID[i].length)] +
                this.GRID[getIJ(i + 1, this.GRID.length)][getIJ(j + 1, this.GRID[i].length)] +
                this.GRID[getIJ(i - 1, this.GRID.length)][getIJ(j + 1, this.GRID[i].length)] +
                this.GRID[getIJ(i + 1, this.GRID.length)][getIJ(j - 1, this.GRID[i].length)];
    }
    // generator of next generarion
    public int[][] generateGrid(int type) {
        this.isLife = false;
        int[][] generation = new int[this.GRID.length][this.GRID[0].length];
        for (int i = 0; i < this.GRID.length; i++) {
            for (int j = 0; j < this.GRID[0].length; j++) {
                if (getNeighbors(i, j) < 2 || getNeighbors(i, j) > 3) {
                    generation[i][j] = 0;
                }
                if (getNeighbors(i, j) == 3) {
                    generation[i][j] = 1;
                    this.isLife = true;
                }
                if (getNeighbors(i, j) == 2 && this.GRID[i][j] == 1) {
                    generation[i][j] = 1;
                    this.isLife = true;
                }
            }
        }
        for (int i = 0; i < this.GRID.length; i++) {
            for (int j = 0; j < this.GRID[0].length; j++) {
                this.GRID[i][j] = generation[i][j];
            }
        }
        return this.GRID;
    }
    // isLife now?
    public boolean getIsLife() {
        return this.isLife;
    }
    public void setIsLife(boolean isLife) {
        this.isLife = isLife;
    }
    // Draw grid array
    public void drawGrid(int type) {
        for (int i = 0; i < this.GRID.length; i++) {
            for (int j = 0; j < this.GRID[0].length; j++) {
                if (this.GRID[i][j] == 0 && type == 0) {
                    System.out.print(" . ");
                } else if (this.GRID[i][j] == 1 && type == 0) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" " + getNeighbors(i, j) + " ");
                }
            }
            System.out.println();
        }
        System.out.println(this.isLife);
        System.out.println();
    }
    // transform method for i, j
    private int getIJ(int n, int bound) {
        if (n < 0) {
            n = bound - 1;
        }
        if (n > bound - 1) {
            n = 0;
        }
        return n;
    }

}