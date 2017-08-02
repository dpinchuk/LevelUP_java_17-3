package home.task9.java;

public class Main {

    public static void main(String[] args) {
        System.out.println("The program for finding prime numbers (Integer) from a given interval" + "\n");
        PrimesImp pn = new PrimesImp();
        System.out.println(pn.printPrimes(pn.getPrimes("2", "23")));
    }

}