package home.task5;

public class Player extends Thread {

    private Game game;

    public Player(Game game) {
        super(); //if to add name -> for test QueueException Exception
        this.game = game;
        start();
    }

    public void run() {
        while (!game.isLine() && !game.isFullGrid()) {

            System.out.println("Current thread [" + Thread.currentThread().getName() + "]");
            try {
                game.nextMove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            game.drawGrid();
            this.delay(IMethods.DELAY);
        }
    }

    private void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}