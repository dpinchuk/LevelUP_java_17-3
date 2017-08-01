package home.task5;

public interface IMethods {

    int M = 3; // bound of grid -> i
    int N = 3; // bound of grid -> j
    int DELAY = 5000; // delay of the program execution

    String[][] getGRID();

    boolean isLineFull(String chr);

    void drawGrid();

    void nextMove() throws InterruptedException;

    boolean isFullGrid();

}