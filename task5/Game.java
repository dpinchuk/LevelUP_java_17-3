package home.task5;

import java.util.Random;

public class Game implements IMethods {

    private String[][] GRID;
    private int[] nextC = new int[2];
    private int[] previousC = new int[2];
    private String previousThreadName;
    private Random random = new Random();
    private final String chrX = " x ";
    private final String chrO = " o ";
    private final String chrNull = " . ";
    private boolean isWinner;

    public Game() {
        GRID = new String[M][N];
        this.initGrid();
        this.drawGrid();
        nextC[0] = 1;
        nextC[1] = 1;
        this.previousThreadName = "";
    }

    public synchronized String[][] getGRID() {
        return GRID;
    }

    // init array
    private void initGrid() {
        for (int i = 0; i < this.GRID.length; i++) {
            for (int j = 0; j < this.GRID[i].length; j++) {
                this.GRID[i][j] = chrNull;
            }
        }
    }

    // draw array-matrix
    public synchronized void drawGrid() {
        for (String[] element : this.GRID) {
            for (String atom : element) {
                System.out.print(atom + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public synchronized boolean isLineFull(String chr) {
        return isFullLine(chr);
    }

    // exit game logic
    private synchronized boolean isFullLine(String chr) {
        if(
                (this.GRID[0][0].equals(chr) && this.GRID[0][1].equals(chr) && this.GRID[0][2].equals(chr)) ||
                (this.GRID[1][0].equals(chr) && this.GRID[1][1].equals(chr) && this.GRID[1][2].equals(chr)) ||
                (this.GRID[2][0].equals(chr) && this.GRID[2][1].equals(chr) && this.GRID[2][2].equals(chr)) ||

                (this.GRID[0][0].equals(chr) && this.GRID[1][0].equals(chr) && this.GRID[2][0].equals(chr)) ||
                (this.GRID[0][1].equals(chr) && this.GRID[1][1].equals(chr) && this.GRID[2][1].equals(chr)) ||
                (this.GRID[0][2].equals(chr) && this.GRID[1][2].equals(chr) && this.GRID[2][2].equals(chr)) ||

                (this.GRID[0][0].equals(chr) && this.GRID[1][1].equals(chr) && this.GRID[2][2].equals(chr)) ||

                (this.GRID[2][0].equals(chr) && this.GRID[1][1].equals(chr) && this.GRID[0][2].equals(chr))
                ) {
            if (!isWinner) {
                System.out.println("Winner [" + previousThreadName + "]");
            }
            isWinner = true;
            return true;
        }
        return  false;
    }

    // next step of gamer
    public synchronized void nextMove() throws InterruptedException {
        if (!this.previousThreadName.equals(Thread.currentThread().getName())) {
            while (!this.GRID[this.nextC[0]][this.nextC[1]].equals(chrNull)) {
                this.nextC[0] = random.nextInt(3);
                this.nextC[1] = random.nextInt(3);
            }
            this.setChar(this.nextC[0], this.nextC[1]);
            System.out.println("Current -> GRID[" + this.nextC[0] + ", " + this.nextC[1] + "] = " +
                    this.GRID[this.nextC[0]][this.nextC[1]]);
            this.previousC[0] = this.nextC[0];
            this.previousC[1] = this.nextC[1];
            this.previousThreadName = Thread.currentThread().getName();
        } else {
            try {
                throw new QueueException(Thread.currentThread().getName(), "The Thread turned out of Queue!");
            } catch (QueueException e) {
                e.printStackTrace();
                e.getCause();

            }
        }
    }

    //set 'x' or 'o'
    private synchronized void setChar(int i, int j) {
        if (this.GRID[this.previousC[0]][this.previousC[1]].equals(chrX)) {
            this.GRID[i][j] = chrO;
            System.out.println(Thread.currentThread().getName() + " -> 'o'");
        } else {
            this.GRID[i][j] = chrX;
            System.out.println(Thread.currentThread().getName() + " -> 'x'");
        }
    }

    //is full grid
    public synchronized boolean isFullGrid() {
        for (String[] element : this.GRID) {
            for (String atom : element) {
                if (atom.equals(chrNull)) {
                    return false;
                }
            }
        }
        System.out.println();
        return true;
    }

    // is line full?
    public synchronized boolean isLine() {
        if (!this.isLineFull(chrX) && !this.isLineFull(chrO)) {
            return false;
        }
        return true;
    }

}