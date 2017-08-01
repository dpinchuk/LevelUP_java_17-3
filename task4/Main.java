package home.task4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Throwable {
        // for Runtime of the program
        long beginTime = System.currentTimeMillis();

        // init coordinates
        String x = "";
        String y = "";
        int iteration = 0;

        // create object
        ABattle seaBattle = new SeaBattle(); //there are 3 different constructors - Empty - init random MxN
        seaBattle.initGrid(seaBattle.getGRID()); // special for empty constructor!

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Sea Battle Logic");
        System.out.println();

        // main block
        while (seaBattle.isAlive(seaBattle.getGRID())) {
            System.out.println("Iteration #" + iteration++);
            seaBattle.toString();
            seaBattle.drawGrid(seaBattle.getGRID());
            System.out.print("Enter x: ");
            x = reader.readLine();
            System.out.print("Enter y: ");
            y = reader.readLine();
            try {
                System.out.println(seaBattle.getBattle(x, y));
            } catch (BattleException e) {
                e.printStackTrace();
                System.out.println("Coordinate (" + e.getI() + ", " + e.getJ() + ") - " + e.getMessage());
            }
            System.out.println();
            Thread.sleep(ABattle.DELAY);
        }
        reader.close();
        // Runtime of the program
        System.out.println("Amount of iterations is " + iteration);
        System.out.println("\n" + "The program was executed " + (System.currentTimeMillis() - beginTime) + " ms");
    }

}