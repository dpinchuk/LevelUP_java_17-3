import home.task10.java.Reader;
import home.task10.java.ReaderImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ReaderImplTest {

    private Reader testReader = new ReaderImpl();

    private final String fileName = "src/main/java/home/task10/data/test1.txt";
    private final String fileNameEmpty = "src/main/java/home/task10/data/test2.txt";

    private List<String> listFull = Arrays.asList("Java", "Java", "Java", "java", "java", "one", "two", "three",
            "four", "one", "one");
    private List<String> listEmpty = Arrays.asList();

    private Map<String, Integer> mapFull =  new HashMap<>();
    private Map<String, Integer> mapSorted =  new TreeMap<>();
    private Map<String, Integer> mapEmpty =  new HashMap<>();

    @Test
    public void testGetWordsListPositive() throws IOException {
        assertEquals(this.listFull, testReader.getWordsList(this.fileName));
        assertEquals(this.listEmpty, testReader.getWordsList(this.fileNameEmpty));
    }

    @Test(expected = IOException.class)
    public void testGetWordsListIOException() throws IOException {
        assertEquals(this.listFull, testReader.getWordsList(""));
    }

    @Test
    public void testGetWordsListNegative() throws IOException {
        assertNotEquals(this.listEmpty, testReader.getWordsList(this.fileName));
        assertNotEquals(this.listFull, testReader.getWordsList(this.fileNameEmpty));
    }

    @Test
    public void testGetFullCollectionPositive() {
        this.mapFull.put("Java", 3);
        this.mapFull.put("java", 2);
        this.mapFull.put("four", 1);
        this.mapFull.put("one", 3);
        this.mapFull.put("three", 1);
        this.mapFull.put("two", 1);

        assertEquals(this.mapFull, this.testReader.getFullCollection(this.listFull));
        assertEquals(this.mapEmpty, this.testReader.getFullCollection(this.listEmpty));
        this.mapFull.clear();
    }

    @Test
    public void testGetFullCollectionNegative() {
        this.mapFull.put("Java", 3);
        this.mapFull.put("java", 2);
        this.mapFull.put("four", 1);
        this.mapFull.put("one", 3);
        this.mapFull.put("three", 1);
        this.mapFull.put("two", 1);

        assertNotEquals(this.mapEmpty, this.testReader.getFullCollection(this.listFull));
        assertNotEquals(this.mapFull, this.testReader.getFullCollection(this.listEmpty));
        this.mapFull.clear();
    }

    @Test
    public void testGetSortAlphabeticallyPositive() {
        this.mapSorted.put("Java", 3);
        this.mapSorted.put("java", 2);
        this.mapSorted.put("four", 1);
        this.mapSorted.put("one", 3);
        this.mapSorted.put("three", 1);
        this.mapSorted.put("two", 1);

        assertEquals(this.mapSorted, this.testReader.getFullCollection(this.listFull));
        assertEquals(this.mapEmpty, this.testReader.getFullCollection(this.listEmpty));
        this.mapSorted.clear();
    }

    @Test
    public void testGetSortAlphabeticallyNegative() {
        this.mapSorted.put("Java", 3);
        this.mapSorted.put("java", 2);
        this.mapSorted.put("four", 1);
        this.mapSorted.put("one", 3);
        this.mapSorted.put("three", 1);
        this.mapSorted.put("two", 1);

        assertNotEquals(this.mapEmpty, this.testReader.getSortAlphabetically(this.listFull));
        assertNotEquals(this.mapSorted, this.testReader.getSortAlphabetically(this.listEmpty));
        this.mapFull.clear();

        Map<String, Integer> mapFull =  new LinkedHashMap<>();
        mapFull.put("two", 1);
        mapFull.put("three", 1);
        mapFull.put("one", 3);
        mapFull.put("Java", 3);
        mapFull.put("four", 1);
        mapFull.put("java", 2);

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        Map<String, Integer> map = this.testReader.getSortAlphabetically(this.listFull);
        for (Map.Entry entry : mapFull.entrySet()) {
            list1.add(String.valueOf(entry.getKey()));
        }
        for (Map.Entry entry : map.entrySet()) {
            list2.add(String.valueOf(entry.getKey()));
        }
        assertNotEquals(list1.get(0), list2.get(0));
    }

    @Test
    public void testGetCollectionByConditionPositive() {
        this.mapSorted.put("Java", 3);
        this.mapSorted.put("java", 2);
        this.mapSorted.put("four", 1);
        this.mapSorted.put("one", 3);
        this.mapSorted.put("three", 1);
        this.mapSorted.put("two", 1);

        assertEquals(this.mapSorted, this.testReader.getFullCollection(this.listFull));
        this.mapSorted.clear();
    }

    @Test
    public void testGetCollectionByConditionNegative() {
        this.mapSorted.put("Java", 1);
        this.mapSorted.put("java", 1);
        this.mapSorted.put("four", 1);
        this.mapSorted.put("one", 1);
        this.mapSorted.put("three", 1);
        this.mapSorted.put("two", 1);

        assertNotEquals(this.mapSorted, this.testReader.getFullCollection(this.listFull));
    }

}