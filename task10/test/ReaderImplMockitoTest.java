import home.task10.java.Reader;
import home.task10.java.ReaderImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Matchers.anyCollection;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReaderImplMockitoTest {

    private String fileName = "src/main/java/home/task10/data/test1.txt";
    private final String fileNameEmpty = "src/main/java/home/task10/data/test2.txt";

    private List<String> listFull = Arrays.asList("Java", "Java", "Java", "java", "java", "one", "two", "three",
            "four", "one", "one");
    private List<String> listEmpty = Arrays.asList();

    private Map<String, Integer> mapFull =  new HashMap<>();
    private Map<String, Integer> mapEmpty =  new HashMap<>();

    @Mock
    private Reader reader;

    @InjectMocks
    private ReaderImpl readerImpl;

    @Test
    public void testGetWordsList() throws IOException {
        when(this.reader.getWordsList(this.fileName)).thenReturn(this.listFull);
        when(this.reader.getWordsList(anyString())).thenReturn(this.listFull);
        when(this.reader.getWordsList(this.fileNameEmpty)).thenReturn(this.listEmpty);
        when(this.reader.getWordsList(anyString())).thenReturn(this.listEmpty);
    }

    @Test
    public void testGetFullCollection() {
        this.mapFull.put("Java", 3);
        this.mapFull.put("java", 2);
        this.mapFull.put("four", 1);
        this.mapFull.put("one", 3);
        this.mapFull.put("three", 1);
        this.mapFull.put("two", 1);
        when(this.reader.getFullCollection(this.listFull)).thenReturn(this.mapFull);
        when(this.reader.getFullCollection((List<String>) anyCollection())).thenReturn(this.mapFull);
        when(this.reader.getFullCollection(this.listEmpty)).thenReturn(this.mapEmpty);
        when(this.reader.getFullCollection((List<String>) anyCollection())).thenReturn(this.mapEmpty);
        this.mapFull.clear();
    }

    @Test
    public void testGetSortAlphabetically() {
        this.mapFull.put("Java", 3);
        this.mapFull.put("java", 2);
        this.mapFull.put("four", 1);
        this.mapFull.put("one", 3);
        this.mapFull.put("three", 1);
        this.mapFull.put("two", 1);
        when(this.reader.getSortAlphabetically(this.listFull)).thenReturn(this.mapFull);
        when(this.reader.getSortAlphabetically((List<String>) anyCollection())).thenReturn(this.mapFull);
        when(this.reader.getSortAlphabetically(this.listEmpty)).thenReturn(this.mapEmpty);
        when(this.reader.getSortAlphabetically((List<String>) anyCollection())).thenReturn(this.mapEmpty);
        this.mapFull.clear();
    }

    @Test
    public void testGetCollectionByCondition() {
        this.mapFull.put("Java", 3);
        this.mapFull.put("java", 2);
        this.mapFull.put("four", 1);
        this.mapFull.put("three", 1);
        when(this.reader.getCollectionByCondition(this.listFull)).thenReturn(this.mapFull);
        when(this.reader.getCollectionByCondition((List<String>) anyCollection())).thenReturn(this.mapFull);
        when(this.reader.getSortAlphabetically(this.listEmpty)).thenReturn(this.mapEmpty);
        when(this.reader.getSortAlphabetically((List<String>) anyCollection())).thenReturn(this.mapEmpty);
        this.mapFull.clear();
    }

}