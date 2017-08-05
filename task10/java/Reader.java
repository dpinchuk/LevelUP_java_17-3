package home.task10.java;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Reader {

    List<String> getWordsList(String fileName) throws IOException;
    Map<String, Integer> getFullCollection(List<String> list);
    Map<String, Integer> getSortAlphabetically(List<String> list);
    Map<String, Integer> getCollectionByCondition(List<String> list);
    void printCollection(String title, Map map);

}