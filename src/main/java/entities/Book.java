package entities;


import java.io.Serializable;

public class Book implements Serializable{

    private static final long serialVersionUID = 10L;

    private String name;
    private Author author;
    private Publisher publisher;
    private int year;
    private int pages;
    private int price;

    public Book() {
    }

    public Book(String name, Author author, Publisher publisher, int year, int pages, int price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " author: " + author.toString() + " г. " + year +  " pub: " + publisher.toString();
    }

    @Override
    public int hashCode() {
        int result = 14;
        result = 31 * result + name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + year;
        result = 31 * result + pages;
        result = 31 * result + price;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
       if(this == obj){
           return true;
       }
       if(obj == null || this.getClass() != obj.getClass()){
           return false;
       }
       Book book = (Book) obj;
       if(!this.name.equals(book.name)) return false;
       if(!this.author.equals(book.author)) return false;
       if(!this.publisher.equals(book.publisher)) return false;
       if(this.year != book.year) return false;
       if(this.pages != book.pages) return false;
       if(this.price != book.price) return false;
       return true;
    }
}
