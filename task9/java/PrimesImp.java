package home.task9.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimesImp implements Primes {

    Primes prime;

    // covered by xUnit
    public List<Integer> getPrimes(String a, String b) {
        List<Integer> cPrimes = new ArrayList<>();
        if (this.isNumber(a) && this.isNumber(b)) {
            int aA = this.getNumberFromString(a);
            int bB = this.getNumberFromString(b);
            if (this.isALessB(aA, bB) && this.isAMoreOne(aA) && isLargeDifference(aA, bB)) {
                for (int i = this.getNumberFromString(a); i <= this.getNumberFromString(b); i++) {
                    if (isPrime(i)) {
                        cPrimes.add(i);
                    }
                }
            }
        }
        return cPrimes;
    }

    // covered by xUnit
    public boolean isPrime(int p) {
        for (int i = 2; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

    // covered by xUnit
    public boolean isNumber(String num) {
        try {
            int n = Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // covered by xUnit
    public boolean isALessB(int a, int b) {
        return a <= b;
    }

    // xUnit
    public boolean isAMoreOne(int a) {
        return a > 1;
    }

    // covered by xUnit -> with NumberFormatException
    public int getNumberFromString(String string) {
        return Integer.parseInt(string);
    }

    // covered by xUnit
    public List<String> printPrimes(List primes) {
        if (primes.isEmpty()) {
            return Arrays.asList("Empty data");
        } else {
            return primes;
        }
    }

    // OutOfMemoty Exception
    public boolean isLargeDifference(int a, int b) {
        if (Math.abs(a - b) <= DIFFERENCE) {
            return true;
        } else {
            return false;
        }
    }

}