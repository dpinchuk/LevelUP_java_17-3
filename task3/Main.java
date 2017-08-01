package home.task3;

/**
 * Created by Дмитрий on 01.07.2017.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        long beginTime = System.currentTimeMillis(); // for Runtime of the program
        int iteration = 0;
        CellularAutomaton cellularAutomaton = new CellularAutomaton(10, 10); //there are 3 different constructors
        System.out.println("Parent Generation");
        cellularAutomaton.initGrid();
        cellularAutomaton.drawGrid(0);
        Thread.sleep(ICell.DELAY); //delay

        while(cellularAutomaton.getIsLife() && iteration != ICell.LIMIT_ITERATIONS) {
            System.out.println("Next child Generation");
            System.out.println("Ieration # " + iteration++); // Printing the count of iterations
            cellularAutomaton.generateGrid(1);
            cellularAutomaton.drawGrid(0); // 0 - drawing '.' and 'X', 1 - drawing numbers of Neighbors
            Thread.sleep(ICell.DELAY);
        }
        // Printing summ of iterations
        System.out.println("Generation died" + "\n" + "The generation lifetime is " + iteration + " iterations");
        // Runtime of the program
        System.out.println( "\n" + "The program was executed " + (System.currentTimeMillis() - beginTime) + " ms");
    }

}