package model;

import entities.Book;
import utility.comparators.BookSortByPublisher;

import java.util.Arrays;

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
        Arrays.sort(books,new BookSortByPublisher());
    }
}
