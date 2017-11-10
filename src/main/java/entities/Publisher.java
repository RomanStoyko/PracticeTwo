package entities;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private String name;

    private List<Book> bookList = new ArrayList<Book>();

    public Publisher(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){
            return  false;
        }
        Publisher publisher = (Publisher)obj;
        return this.name.equals(publisher.name);

    }

    @Override
    public int hashCode() {
        int result = 19;
        result = 31 * result + name.hashCode();
        return result;
    }
}
