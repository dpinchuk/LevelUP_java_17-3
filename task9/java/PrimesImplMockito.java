package home.task9.java;

import java.util.List;

public class PrimesImplMockito {

    private Primes primes;

    public PrimesImplMockito(Primes primes) {
        this.primes = primes;
    }

    public List<Integer> getPrimes(String a, String b) {
        return this.primes.getPrimes(a, b);
    }

    public boolean isPrime(int p) {
        return this.primes.isPrime(p);
    };

    public boolean isNumber(String num) {
        return this.primes.isNumber(num);
    };

    public boolean isALessB(int a, int b) {
        return this.primes.isALessB(a, b);
    };

    public boolean isAMoreOne(int a) {
        return this.primes.isAMoreOne(a);
    };

    public int getNumberFromString(String string) {
        return this.primes.getNumberFromString(string);
    };

    public List<String> printPrimes(List primesList) {
        return this.primes.printPrimes(primesList);
    };

    public boolean isLargeDifference(int a, int b) {
        return this.primes.isLargeDifference(a, b);
    };

}