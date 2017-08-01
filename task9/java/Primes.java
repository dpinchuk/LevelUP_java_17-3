package home.task9.java;

import java.util.List;

public interface Primes {

    public List<Integer> getPrimes(String a, String b);

    boolean isPrime(int p);

    boolean isNumber(String num);

    boolean isALessB(int a, int b);

    boolean isAMoreOne(int a);

    int getNumberFromString(String string);

    List<String> printPrimes(List primes);

}