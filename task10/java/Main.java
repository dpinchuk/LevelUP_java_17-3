package home.task10.java;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> list;
        Map<String, Integer> map;

        ReaderImpl readerImpl = new ReaderImpl();
        list = readerImpl.getWordsList("src/main/java/home/task10/data/test1.txt");

        //1 task -> Count occurance of same words in collection
        map = readerImpl.getFullCollection(list);
        readerImpl.printCollection("\n" + "[Full unSorted collection]", map);

        //2 task -> Sort words alphabetically
        map = readerImpl.getSortAlphabetically(list);
        readerImpl.printCollection("\n" + "[Full Sorted alphabetically collection]", map);

        //3 task -> Remove words with lenght < = 3
        map = readerImpl.getCollectionByCondition(list);
        readerImpl.printCollection("\n" + "[Collection of words with a length of more than 3 characters]", map);
    }

}