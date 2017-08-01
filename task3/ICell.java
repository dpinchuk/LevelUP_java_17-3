package home.task3;

/**
 * Created by Дмитрий on 01.07.2017.
 */
public interface ICell {
    int M = 50; // bound of grid -> i
    int N = 50; // bound of grid -> j
    int LIMIT_ITERATIONS = 500; // max count of iterations
    int DELAY = 100; // delay of the program execution

    void drawGrid(int type); // drawing the grid
    int[][] initGrid(); // init new daa for the grid
    int[][] generateGrid(int type); // generate new generations
}