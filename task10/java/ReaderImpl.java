package home.task10.java;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReaderImpl implements Reader {

    // get list from a file
    public List<String> getWordsList(String fileName) throws IOException {
        List list = new ArrayList<>();
        Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8)
                .forEach(word -> list.addAll(Arrays.asList(word.split("[`~!@\\-#№$%;^&*()_+|={}:\"<>,.?/'\\s]+"))));
        return list;
    }

    // get full unsorted collection
    public Map<String, Integer> getFullCollection(List<String> list) {
        return list
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(k -> 1)));
    }

    // get sorted alphabetically collection
    public Map<String, Integer> getSortAlphabetically(List<String> list) {
        return new TreeMap(list
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(k -> 1))));
    }

    // get collection with removed words with length less than 3 characters
    public Map<String, Integer> getCollectionByCondition(List<String> list) {
        return list
                .stream()
                .filter(key -> key.length() > 3)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(k -> 1)));
    }

    // print collection
    public void printCollection(String title, Map map) {
        System.out.println(title);
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

}