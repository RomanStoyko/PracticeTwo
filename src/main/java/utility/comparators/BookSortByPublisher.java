package utility.comparators;

import entities.Book;

import java.util.Comparator;

public class BookSortByPublisher implements Comparator {

    public int compare(Object o1, Object o2) {
        String name1 = ((Book) o1).getPublisher().getName();
        String name2 = ((Book) o2).getPublisher().getName();
        return name1.compareToIgnoreCase(name2);
    }
}
