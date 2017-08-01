package home.task4;

public class BattleException extends Exception {

    private int i; // x-coordinate
    private int j; // y-coordinate

    private String message; // Message in case of exception

    public BattleException(String message, int i, int j) { //constructor
        super(message); // call the constructor of Super Class Exception and insert our message
        this.message = message;
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public String getMessage() {
        return message;
    }

}