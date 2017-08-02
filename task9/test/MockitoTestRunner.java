import home.task9.java.PrimesImplMockito;
import home.task9.java.Primes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class MockitoTestRunner {

    @Mock
    private Primes primes;

    @InjectMocks
    private PrimesImplMockito primesImp = new PrimesImplMockito(null);

    @Test
    public void test() {
        this.primesImp.getPrimes("2", "23");
        verify(this.primes).getPrimes("2", "23");
    }

}