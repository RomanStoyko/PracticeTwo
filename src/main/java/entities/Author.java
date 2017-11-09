package entities;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String firstName;
    private String secondName;

    private List<Book> bookList = new ArrayList<Book>();


    public Author() {
    }

    public Author(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


    @Override
    public String toString() {
        return secondName + " " + firstName.charAt(0) +".";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){
            return  false;
        }
        Author author = (Author)obj;
        if(!this.firstName.equals(author.firstName)){
            return false;
        }
        return this.secondName.equals(author.secondName);

    }
}
