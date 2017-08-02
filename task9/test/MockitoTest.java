import home.task9.java.Primes;
import home.task9.java.PrimesImplMockito;
import home.task9.java.PrimesImp;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.exceptions.misusing.UnfinishedStubbingException;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    private final List<Integer> listPrimesFull = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23);
    private final List<String> listPrimesString = Arrays.asList("2", "3", "5", "7", "11", "13", "17", "19", "23");
    private final List<Integer> listPrimesFew = Arrays.asList(2);
    private final List<Integer> listPrimesEmpty = new ArrayList<>();

    private final Random random = new Random();

    private String someRandomString() {
        return String.valueOf(new Random().nextInt());
    }

    private Matcher<List<Integer>> isList() {
        return new ArgumentMatcher() {
            @Override
            public boolean matches(Object argument) {
                return argument.equals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23));
            }
        };
    }

    @Mock
    private Primes primes;

    @InjectMocks
    private PrimesImplMockito primesImplMockito;

    @Before // given
    public void setUp() {
        this.primes = mock(Primes.class);
        this.primesImplMockito = new PrimesImplMockito(this.primes);
    }

    @Test //Check that there was a method call
    public void testGetPrimesPositive() {
        this.primes.getPrimes("2", "23");
        verify(primes).getPrimes("2", "23");
    }

    @Test //Indicate for mock (stab) what exactly he should return
    public void testGetPrimesIndicateReturn() {
        when(this.primes.getPrimes("2", "23")).thenReturn(this.listPrimesFull);
        assertEquals(this.listPrimesFull, this.primesImplMockito.getPrimes("2", "23"));
    }

    @Test //If it is necessary to ignore an input parameters?
    public void testGetPrimesIgnoreParameters() {
        this.primes.getPrimes(someRandomString(), someRandomString());
        verify(this.primes).getPrimes(anyString(), anyString());
    }

    @Test //That they did not give, what they stabed?
    public void testGetPrimesParameterWrong() {
        when(this.primes.getPrimes("2", "23")).thenReturn(this.listPrimesFull);
        assertEquals(this.listPrimesEmpty, this.primesImplMockito.getPrimes("two", "twenty three"));
    }

    @Test // What if we want to ignore the parameters?
    public void testGetPrimesIgnoreParameterWrong() {
        when(this.primes.getPrimes(anyString(), anyString())).thenReturn(this.listPrimesFull);
        assertEquals(this.listPrimesFull, this.primesImplMockito.getPrimes("2", "23"));
    }

    @Test(expected = NumberFormatException.class) // If we want to simulate a failure
    public void testGetPrimesCrash() {
        when(this.primes.getPrimes(anyString(), anyString())).thenThrow(new NumberFormatException());
        this.primesImplMockito.getPrimes("two", "twenty three");
    }

    @Test(expected = Exception.class) // If the method is void
    public void testGetPrimesIfVoidMethod() {
        doThrow(new Exception()).when(this.primes).getPrimes("2", "23");
        this.primesImplMockito.getPrimes("2", "23");
    }

    @Test // Check the number of calls
    public void testGetPrimesCheckTimes() {
        this.primesImplMockito.getPrimes("2", "23");
        this.primesImplMockito.getPrimes("3", "11");
        this.primesImplMockito.getPrimes("3", "11");
        this.primesImplMockito.getPrimes("21", "49");
        this.primesImplMockito.getPrimes("2", "23");
        this.primesImplMockito.getPrimes("2", "23");
        this.primesImplMockito.getPrimes("0", "1");

        verify(primes, times(3)).getPrimes("2", "23");
        verify(primes, times(2)).getPrimes("3", "11");
        verify(primes, atLeastOnce()).getPrimes("2", "23");
        verify(primes, never()).getPrimes("9", "11");
        verify(primes, atMost(7)).getPrimes(anyString(), anyString());

    }

    @Test // Substitution of the real class method
    public void testGetPrimesSpyParameters() {
        Primes spyPrimes = spy(new PrimesImp());
        PrimesImplMockito primesImp = new PrimesImplMockito(spyPrimes);
        assertEquals(this.listPrimesFull, primesImp.getPrimes("2", "23")); //It was
        doReturn(this.listPrimesFew).when(spyPrimes).getPrimes("2", "23");
        assertEquals(this.listPrimesFew, primesImp.getPrimes("2", "23")); //Has become
    }

    @Test // Spy from the mock class is different in that in spy by default, real methods are called
    public void testGetPrimesSpyCase() {
        Primes spyPrimes = spy(PrimesImp.class);
        PrimesImplMockito primesImp = new PrimesImplMockito(spyPrimes);

        assertEquals(this.listPrimesFull, primesImp.getPrimes("2", "23")); //It was
        doReturn(this.listPrimesFew).when(spyPrimes).getPrimes("2", "23"); //case
        assertEquals(this.listPrimesFew, primesImp.getPrimes("2", "23"));
    }

    // If we do not know what's the matter
    @Test(expected = UnfinishedStubbingException.class)
    public void checkUssage() {
        // no method willReturn
        given(this.primes.getPrimes("2", "23")); //.willReturn();
        List<Integer> result = this.primesImplMockito.getPrimes("2", "23");
        assertThat(result, isList());
        validateMockitoUsage(); // Diagnostic method
    }

    // mock reset
    @Test
    public void resetMock() {
        when(this.primes.getPrimes("2", "23")).thenReturn(this.listPrimesFew);
        this.primesImplMockito.getPrimes("2", "23");
        this.primesImplMockito.getPrimes("2", "23"); //when
        verify(this.primes, times(2)).getPrimes("2", "23");  // then

        reset(this.primes);

        this.primesImplMockito.getPrimes("2", "23");
        this.primesImplMockito.getPrimes("2", "23");
        this.primesImplMockito.getPrimes("2", "23");
        verify(this.primes, times(3)).getPrimes("2", "23");

    }

    @Test
    public void captures() {

        this.primesImplMockito.getPrimes("2", "23");
        this.primesImplMockito.getPrimes("2", "2");
        this.primesImplMockito.getPrimes("0", "1");
        // then
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(this.primes, times(3)).getPrimes(argument.capture(), argument.capture());
        assertEquals("[2, 23, 2, 2, 0, 1]", argument.getAllValues().toString());
    }

    @Test //If we want to verify that the mock did not twitch anymore
    public void neverCallMockMethod() {
        this.primesImplMockito.getPrimes("2", "23"); // when
        verify(this.primes).getPrimes("2", "23");        // then
        verifyNoMoreInteractions(this.primes);
    }

    @Test //If we want to verify that the mock did not twitch
    public void neverCallMock() {
        verifyZeroInteractions(this.primes);
    }

    // Mockito uses equals to check for equal (eq)
    @Test
    public void equals() {
        when(this.primes.getPrimes(eq("2"), eq("23"))).thenReturn(this.listPrimesFew);
        assertEquals(this.listPrimesFew, this.primesImplMockito.getPrimes("2", "23")); // when, then
    }

    // return default
    @Test
    public void byDefaultReturns() {
        List list = mock(List.class);
        assertEquals(0, list.size());
        assertFalse(list.isEmpty());
        assertNull(list.iterator());
        assertEquals("[]", list.subList(1, 2).toString());
    }

    @Test
    public void testIsPrimePositive() {
        when(this.primes.isPrime(2)).thenReturn(true);
        assertEquals(true, this.primesImplMockito.isPrime(2));
    }

    @Test
    public void testIsNumberPositive() {
        when(this.primes.isNumber("2")).thenReturn(true);
        assertEquals(true, this.primesImplMockito.isNumber("2"));
    }

    @Test
    public void testIsALessBPositive() {
        when(this.primes.isALessB(2, 23)).thenReturn(true);
        assertEquals(true, this.primesImplMockito.isALessB(2, 23));
    }

    @Test
    public void testIsAMoreOnePositive() {
        when(this.primes.isAMoreOne(2)).thenReturn(true);
        assertEquals(true, this.primesImplMockito.isAMoreOne(2));
    }

    @Test
    public void testGetNumberFromStringPositive() {
        when(this.primes.getNumberFromString("2")).thenReturn(2);
        assertEquals(2, this.primesImplMockito.getNumberFromString("2"));
    }

    @Test
    public void testPrintPrimesPositive() {
        when(this.primes.printPrimes(this.listPrimesFull)).thenReturn(this.listPrimesString);
        assertEquals(this.listPrimesString, this.primesImplMockito.printPrimes(this.listPrimesFull));
    }

    @Test
    public void testIsLargeDifferencePositive() {
        when(this.primes.isNoLargeDifference(2, 1002)).thenReturn(true);
        assertEquals(true, this.primesImplMockito.isLargeDifference(2, 1002));
    }

}