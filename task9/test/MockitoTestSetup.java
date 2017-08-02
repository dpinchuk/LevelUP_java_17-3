import home.task9.java.PrimesImplMockito;
import home.task9.java.Primes;
import org.junit.Before;
import org.junit.Test;

import org.mockito.*;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockitoTestSetup {
    private Primes primes;
    private PrimesImplMockito mockPrimes;

    @Before
    public void init() {
        this.primes = Mockito.mock(Primes.class);
        this.mockPrimes = new PrimesImplMockito(primes);
    }

    @Test
    public void test() {
        this.mockPrimes.getPrimes("2", "23");
        verify(this.primes).getPrimes("2", "23");
    }
}

