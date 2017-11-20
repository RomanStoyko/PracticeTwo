package model;

import entities.Book;


import java.util.Arrays;
import java.util.Comparator;

public class Model {

    public <T> T getObjFromArray(T[] input, int pos){
        if(input == null || pos < 0 || pos >= input.length){
            return null;
        }

        return input[pos];
    }

    public Book[] filterByYear(Book[] books, int year){
        if (books == null || year < 0 ){
            return null;
        }

        Book[] result = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            if(books[i] == null){
                continue;
            }
            if(books[i].getYear() > year){
                result[i] = books[i];
            }
        }
        return result;
    }

    public void sortByPublisher(Book[] books){
        Arrays.sort(books, new Comparator<Book>() {
            public int compare(Book o1, Book o2) {
                String name1 = o1.getPublisher().getName();
                String name2 = o2.getPublisher().getName();
                return name1.compareToIgnoreCase(name2);
            }
        });
    }
}
