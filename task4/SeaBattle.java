package home.task4;

public class SeaBattle<T> extends ABattle {

    SeaBattle(int m, int n) {
        super(m, n);
    }

    SeaBattle() {
        super();
    }

    SeaBattle(String string) {
        super(string);
    }

    // check coordinates for current array
    public String getBattle(String i, String j) throws Throwable {
        return this.checkCoordinate(this.getGRID(), i, j);
    }

    private BattleException initException(String string, Exception exception, int i, int j) throws Throwable {
        throw new BattleException(string, i, j).initCause(exception);
    }

    // main logic
    private String checkCoordinate(int[][] array, String i, String j) throws Throwable {
        int iI = 0;
        int jJ = 0;
        try {
            iI = Integer.valueOf(i);
            jJ = Integer.valueOf(j);
            if (array[iI][jJ] == 1) {
                array[iI][jJ] = 0;
                return "Kill!";
            }
        } catch (NumberFormatException e1) {
            this.initException("Out of Integer or NaN!", e1, iI, jJ);
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.initException("Out of Grid!", e2, iI, jJ);
        }
        return "Miss!";
    }

    public T modifyGrid(int[][] array) { // Unrealized method in the class SeaBattle.java
        return null;
    }

    public T sortGrid(int[][] array) { // Unrealized method in the class SeaBattle.java
        return null;
    }

    public T checkGrid(int[][] array) { // Unrealized method in the class SeaBattle.java
        return null;
    }

}