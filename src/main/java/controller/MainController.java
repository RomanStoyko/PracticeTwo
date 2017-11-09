package controller;


import entities.Author;
import entities.Book;
import entities.Publisher;
import model.Model;
import utility.Generator;
import view.Messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {

    private static final Model MODEL = new Model();
    private static final Messenger VIEW = new Messenger();
    private static final Generator BASE = new Generator();

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String readValue;

    public void work() throws IOException {
        VIEW.afterGen();
        VIEW.mainInfo();
        while ((readValue = reader.readLine()) != null){
            if (readValue.equals("-ext")) {
                break;
            }else  if (readValue.equals("-prt")) {
                printAll();
            }else  if (readValue.equals("-aut")) {
                authorBook();
            }else  if (readValue.equals("-pub")) {
                publisherBook();
            }else  if (readValue.equals("-yea")) {
                yearBook();
            }else  if (readValue.equals("-srp")) {
                sortBook();
            }
        }

        reader.close();
    }

    private void printAll() {
        VIEW.printInputArray(BASE.getBooks());
        VIEW.mainInfo();
    }

    private static void authorBook() throws IOException{
        VIEW.printInputArray(BASE.getAuthors());
        while ((readValue = reader.readLine()) != null){
            if(readValue.equals("-ext")) {
                VIEW.mainInfo();
                break;
            }
            if(readValue.equals("-ite")) {
                VIEW.printInputArray(BASE.getAuthors());
                continue;
            }
            int number = 0;
            try {
                number = Integer.parseInt(readValue);
                Author author = MODEL.getObjFromArray(BASE.getAuthors(), number - 1);
                if(author == null){
                    VIEW.printErrorNumberInfo();
                    VIEW.printEnterInt();
                    continue;
                }
                VIEW.printInputArrayList(author.getBookList());
                VIEW.printEnterInt();

            } catch (NumberFormatException e) {

                VIEW.printErrorNumberInfo();
                VIEW.printEnterInt();
            }
        }

    }

    private static void publisherBook() throws IOException{
        VIEW.printInputArray(BASE.getPublishers());
        while ((readValue = reader.readLine()) != null){
            if(readValue.equals("-ext")) {
                VIEW.mainInfo();
                break;
            }
            if(readValue.equals("-ite")) {
                VIEW.printInputArray(BASE.getPublishers());
                continue;
            }
            int number = 0;
            try {
                number = Integer.parseInt(readValue);
                Publisher publisher = MODEL.getObjFromArray(BASE.getPublishers(), number - 1);
                if(publisher == null){
                    VIEW.printErrorNumberInfo();
                    VIEW.printEnterInt();
                    continue;
                }
                VIEW.printInputArrayList(publisher.getBookList());
                VIEW.printEnterInt();

            } catch (NumberFormatException e) {

                VIEW.printErrorNumberInfo();
                VIEW.printEnterInt();
            }
        }
    }

    private static void yearBook() throws IOException {
        VIEW.printEnterInt();
        while ((readValue = reader.readLine()) != null){
            if(readValue.equals("-ext")) {
                VIEW.mainInfo();
                break;
            }
            int number = 0;
            try {
                number = Integer.parseInt(readValue);
                Book[] books = MODEL.filterByYear(BASE.getBooks(), number);
                if(books == null){
                    VIEW.printErrorNumberInfo();
                    VIEW.printEnterInt();
                    continue;
                }
                VIEW.printInputArray(books);
                VIEW.printAftreInputArray();

            } catch (NumberFormatException e) {

                VIEW.printErrorNumberInfo();
                VIEW.printEnterInt();
            }
        }
    }

    private static void sortBook() {
        MODEL.sortByPublisher(BASE.getBooks());
        VIEW.printInputArray(BASE.getBooks());
        VIEW.mainInfo();
    }


}
