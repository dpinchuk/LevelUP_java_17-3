package home.task9.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimesImp implements Primes {

    Primes prime;

    public List<Integer> getPrimes(String a, String b) {
        List<Integer> cPrimes = new ArrayList<>();
        if (this.isNumber(a) && this.isNumber(b)) {
            int aA = this.getNumberFromString(a);
            int bB = this.getNumberFromString(b);
            if (this.isALessB(aA, bB) && this.isAMoreOne(aA)) {
                for (int i = this.getNumberFromString(a); i <= this.getNumberFromString(b); i++) {
                    if (isPrime(i)) {
                        cPrimes.add(i);
                    }
                }
            }
        }
        return cPrimes;
    }

    // xUnit
    public boolean isPrime(int p) {
        for (int i = 2; i <= (int) Math.sqrt(p); i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

    // xUnit
    public boolean isNumber(String num) {
        try {
            int n = Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // xUnit
    public boolean isALessB(int a, int b) {
        return a <= b;
    }

    // xUnit
    public boolean isAMoreOne(int a) {
        return a > 1;
    }

    // xUnit -> with Exception
    public int getNumberFromString(String string) {
        return Integer.parseInt(string);
    }

    // xUnit
    public List<String> printPrimes(List primes) {
        if (primes.isEmpty()) {
            return Arrays.asList("Empty data");
        } else {
            return primes;
        }
    }

}