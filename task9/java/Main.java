package home.task9.java;

public class Main {

    public static void main(String[] args) {
        PrimesImp pn = new PrimesImp();
        System.out.println(pn.printPrimes(pn.getPrimes("2147483600", "2147483641")));
    }

}