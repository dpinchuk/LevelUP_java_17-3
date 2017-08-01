import home.task9.java.PrimesImp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PrimeNumbersTest  {

    private PrimesImp prime = new PrimesImp();
    private final List<Integer> listPrimesFull = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23);
    private final List<Integer> listPrimesFew = Arrays.asList(2);
    private final List<Integer> listPrimesEmpty = new ArrayList<>();
    private final List listPrimesEmptyString = Arrays.asList("Empty data");

    @Test // 1. getPrimes() +
    public void testGetPrimesPositive() {
        assertEquals(this.listPrimesFull, this.prime.getPrimes("2", "23"));
        assertEquals(this.listPrimesFew, this.prime.getPrimes("2", "2"));
        assertEquals(this.listPrimesFull, this.prime.getPrimes(new String("2"), new String("23")));
    }

    @Test // 2. getPrimes() -
    public void testGetPrimesNegative() {
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes(new String(), new String()));
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes(null, null));
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes("", ""));
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes("23", "2"));
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes("\t&#177;", "&"));
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes("<input>", "<script>alert(\"xss-inj!\")</script>"));
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes("two", "23"));
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes("2", "twenty three"));
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes("0", "2"));
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes("0", "0"));
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes("-23", "-2"));
        assertEquals(this.listPrimesEmpty, this.prime.getPrimes("-2", "-23"));
    }

    @Test // 3. isNumber() +
    public void testIsNumberPositive() {
        assertEquals(true, this.prime.isNumber("11"));
    }

    @Test // 4. isNumber() -
    public void testIsNumberNegative() {
        assertNotEquals(true, this.prime.isNumber("fifteen"));
        assertNotEquals(true, this.prime.isNumber("null"));
        assertNotEquals(true, this.prime.isNumber("7.11"));
    }

    @Test // 5. isALessB() +
    public void testIsALessBPositive() {
        assertEquals(true, this.prime.isALessB(2, 4));
    }

    @Test // 6. isALessB() -
    public void testIsALessBNegative() {
        assertNotEquals(true, this.prime.isALessB(4, 2));
    }

    @Test // 7. isAMoreTwo() +
    public void testIsAMoreOnePositive() {
        assertEquals(true, this.prime.isAMoreOne(3));
    }

    @Test // 8. isAMoreTwo() -
    public void testIsAMoreOneNegative() {
        assertNotEquals(true, this.prime.isAMoreOne(1));
    }

    @Test // 9. gGetNumberFromStringNegative() +
    public void testGetNumberFromStringPositive() {
        assertEquals(11, this.prime.getNumberFromString("11"));
    }

    // 10. gGetNumberFromStringNegative() -
    @Test(expected = NumberFormatException.class)
    public void testGetNumberFromStringNegative() {
        int result1 = this.prime.getNumberFromString("fifteen");
        int result2 = this.prime.getNumberFromString("11.7");
    }

    @Test // 11. isPrime() +
    public void testIsPrimePositive() {
        assertEquals(true, this.prime.isPrime(11));
    }

    @Test // 12. isPrime() -
    public void testIsPrimeNegative() {
        assertNotEquals(true, this.prime.isPrime(12));
    }

    @Test // 13. printPrimes() -
    public void testPrintPrimesPositive() {
        assertEquals(this.listPrimesFull, this.prime.printPrimes(this.listPrimesFull));
    }

    @Test // 14.  printPrimes() -
    public void testPrintPrimesNegative() {
        assertEquals(this.listPrimesEmptyString, this.prime.printPrimes(this.listPrimesEmpty));
    }

}