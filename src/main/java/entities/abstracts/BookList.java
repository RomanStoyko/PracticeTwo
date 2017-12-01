package entities.abstracts;

import entities.Book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class BookList implements Serializable {
    private List<Book> bookList = new ArrayList<Book>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
