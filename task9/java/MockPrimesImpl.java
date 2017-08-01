package home.task9.java;

import java.util.List;

public class MockPrimesImpl {

    private Primes primes;

    public MockPrimesImpl(Primes primes) {
        this.primes = primes;
    }

    public List<Integer> getPrimes(String a, String b) {
        return primes.getPrimes(a, b);
    }

    public boolean isPrime(int p) {
        return primes.isPrime(p);
    };

    public boolean isNumber(String num) {
        return primes.isNumber(num);
    };

    public boolean isALessB(int a, int b) {
        return primes.isALessB(a, b);
    };

    public boolean isAMoreOne(int a) {
        return primes.isAMoreOne(a);
    };

    public int getNumberFromString(String string) {
        return primes.getNumberFromString(string);
    };

    public List<String> printPrimes(List primesList) {
        return primes.printPrimes(primesList);
    };

}