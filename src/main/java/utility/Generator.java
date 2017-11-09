package utility;

import entities.Author;
import entities.Book;
import entities.Publisher;

public class Generator {

    private final static int BSIZE = 30;

    private final static String[] FIRSTNAME = {"Антон","Орест", "Максим","Евгений",
                                                "Александр","Артем","Сергей","Дмитрий"};
    private final static String[] SECONDNAME = {"Беседкин","Бусел", "Горностай","Грицай",
                                                 "Максименко", "Мариненко", "Мужиливск", "Онищенко"};
    private final static String[] BOOKNAME = {
            "ThomsonReuters",
            "RELX Group",
            "Wolters Kluwer",
            "Penguin Random House",
            "Phoenix Publishing and Media Company",


    };

    private final static String[] PUBLISHRNAME = {
            "Things Fall Apart",
            "Fairy tales",
            "The Divine Comedy",
            "Epic of Gilgamesh",
            "Book of Job",
            "One Thousand and One Nights",
            "Njál's Saga",
            "Pride and Prejudice",
            "Le Père Goriot",
            "Molloy, Malone Dies, The Unnamable, a trilogy",
            "The Decameron",
            "Ficciones",
            "Wuthering Heights",
            "The Stranger",
            "Poems",
            "Journey to the End of the Night",
            "Don Quixote",
            "The Canterbury Tales",
            "Stories",
            "Nostromo",
            "Great Expectations",
            "Jacques the Fatalist",
            "Berlin Alexanderplatz",
            "Crime and Punishment",
            "The Idiot"
    };


    private Book[] books = new Book[BSIZE];
    private Author[] authors = new Author[BSIZE];
    private Publisher[] publishers = new Publisher[BSIZE];

    {

        for(int i = 0; i < BSIZE; i++){
            Author author = generateAuror();
            Publisher publisher = generatePublisher();
            Book book = new Book(
                    BOOKNAME[(int)(Math.random()*BOOKNAME.length)],
                    author,
                    publisher,
                    1900 + (int)(Math.random()*100),
                    (int)(Math.random()*1000),
                    (int)(Math.random()*100000)
            );
            author.getBookList().add(book);
            publisher.getBookList().add(book);

            addBook(book);
        }


    }

    private void addBook(Book book){
        for (int i = 0; i < this.books.length; i++) {
            if(this.books[i]==null){
                this.books[i] =  book;
                return;
            }
        }
    }

    private Author generateAuror(){
        boolean needAddAutor = true;
        Author author = new Author(FIRSTNAME[(int)(Math.random()*FIRSTNAME.length)], SECONDNAME[(int)(Math.random()*SECONDNAME.length)]);
        for (Author fromAutors:authors) {
            if (fromAutors ==null){
                break;
            }
            if(fromAutors.equals(author)){
                author = fromAutors;
                needAddAutor = false;
            }
        }

        if(needAddAutor){
            addAutor(author);
        }
        return author;
    }

    private void addAutor(Author author){
        for (int i = 0; i < this.authors.length; i++) {
            if(this.authors[i]==null){
                this.authors[i] =  author;
                return;
            }
        }
    }


    private Publisher generatePublisher(){
        boolean needAdd = true;
        Publisher publisher = new Publisher(PUBLISHRNAME[(int)(Math.random()*PUBLISHRNAME.length)]);
        for (Publisher frompublishers:publishers) {
            if (frompublishers == null){
                break;
            }
            if(frompublishers.equals(publisher)){
                publisher = frompublishers;
                needAdd = false;
            }
        }

        if(needAdd){
            addPublisher(publisher);
        }
        return publisher;
    }

    private void addPublisher(Publisher publisher){
        for (int i = 0; i < this.publishers.length; i++) {
            if(this.publishers[i]==null){
                this.publishers[i] =  publisher;
                return;
            }
        }
    }


    public Book[] getBooks() {
        return books;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public Publisher[] getPublishers() {
        return publishers;
    }
}
