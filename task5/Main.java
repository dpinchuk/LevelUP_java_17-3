package home.task5;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        long beginTime = System.currentTimeMillis();

        Game game = new Game();

        Thread player1Thread = new Thread(new Player(game));
        Thread player2Thread = new Thread(new Player(game));

        player1Thread.join();
        System.out.println("Thread [" + player1Thread.getName() + "] finished." + "\n");

        player2Thread.join();
        System.out.println("Thread [" + player2Thread.getName() + "] finished." + "\n");

        System.out.println("All Threads finished!" + "\n");
        System.out.println("\n" + "The program was executed " + (System.currentTimeMillis() - beginTime) + " ms");

    }

}
