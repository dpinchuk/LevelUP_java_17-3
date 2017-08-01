package home.task4;

public interface IMethods<T> {

    int M = 10; // bound of grid -> i
    int N = 10; // bound of grid -> j
    int DELAY = 1000; // delay of the program execution

    void drawGrid(int[][] array); // General methods

    Boolean isAlive(int[][] array); // General methods

    T initGrid(int[][] array); // for special using

    T modifyGrid(int[][] array); // for special using

    T sortGrid(int[][] array); // for special using

    T checkGrid(int[][] array); // for special using

}