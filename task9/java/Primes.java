package home.task9.java;

import java.util.List;

public interface Primes {

    int DIFFERENCE = 10000;

    List<Integer> getPrimes(String a, String b); // -> returns prime numbers from the predetermined interval as List

    boolean isPrime(int p); // checks for prime

    boolean isNumber(String num); // checks for a number

    boolean isALessB(int a, int b); // checks for A <= B

    boolean isAMoreOne(int a); // checks for A > 1

    int getNumberFromString(String string); // returns Number From a String

    List<String> printPrimes(List primes); // prints Empty or Full collection

    boolean isLargeDifference(int a, int b); // check for difference between A and B

}