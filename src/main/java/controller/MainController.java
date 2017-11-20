package controller;

import entities.Book;
import entities.abstracts.BookList;
import model.Model;
import utility.Generator;
import utility.TextStrings;
import view.Messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {

    private Model model;
    private Messenger view;
    private Generator base;

    private TextStrings textStrings;

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String readValue;

    public MainController() {
    }

    public MainController(Model model, Messenger view, Generator base) {
        this.model = model;
        this.view = view;
        this.base = base;
    }

    public void work() throws IOException {
        view.print(textStrings.GENERATE_FINISH);
        view.print(textStrings.SEPARATE_LINE);
        view.print(textStrings.MENU);
        while ((readValue = reader.readLine()) != null){
            if (readValue.equals("-ext")) {
                break;
            }else  if (readValue.equals("-prt")) {
                printAll();
            }else  if (readValue.equals("-aut")) {
                printListBook(base.getAuthors());
            }else  if (readValue.equals("-pub")) {
                printListBook(base.getPublishers());
            }else  if (readValue.equals("-yea")) {
                yearBook();
            }else  if (readValue.equals("-srp")) {
                sortBook();
            }
        }

        reader.close();
    }

    private void printAll() {
        view.printInputArray(base.getBooks());
        printMainInfo();
    }

    private void printListBook(BookList[] inputList) throws IOException{
        view.printInputArray(inputList);
        printAftreInputArray();
        view.print(textStrings.ITEM_LIST);
        while ((readValue = reader.readLine()) != null){
            if(readValue.equals("-ext")) {
                printMainInfo();
                break;
            }
            if(readValue.equals("-ite")) {
                view.printInputArray(inputList);
                printAftreInputArray();
                view.print(textStrings.ITEM_LIST);
                continue;
            }
            int number = 0;
            try {
                number = Integer.parseInt(readValue);
                BookList bookList = model.getObjFromArray(inputList, number - 1);
                if(bookList == null){
                    printErrorNumberInfo();
                    printEnterInt();
                    continue;
                }
                view.printInputArrayList(bookList.getBookList());
                printEnterInt();

            } catch (NumberFormatException e) {

                printErrorNumberInfo();
                printEnterInt();
            }
        }

    }

    private void yearBook() throws IOException {
       printEnterInt();
        while ((readValue = reader.readLine()) != null){
            if(readValue.equals("-ext")) {
                printMainInfo();
                break;
            }
            int number = 0;
            try {
                number = Integer.parseInt(readValue);
                Book[] books = model.filterByYear(base.getBooks(), number);
                if(books == null){
                    printErrorNumberInfo();
                    printEnterInt();
                    continue;
                }
                view.printInputArray(books);
                printAftreInputArray();

            } catch (NumberFormatException e) {

                printErrorNumberInfo();
                printEnterInt();
            }
        }
    }

    private void sortBook() {
        model.sortByPublisher(base.getBooks());
        view.printInputArray(base.getBooks());
        printMainInfo();
    }

    /**
     * print main info
     *
     */
    private void printMainInfo(){
        view.print(textStrings.SEPARATE_LINE);
        view.print(textStrings.MENU);
        view.print(textStrings.EXIT);
    }

    /**
     * print massage about error
     *
     */
    private void printErrorNumberInfo(){
        view.print(textStrings.INVALID_NUMBER);
        view.print(textStrings.EXIT);
    }

    /**
     * print massage about input int
     *
     */
    private  void printEnterInt(){
        view.print(textStrings.INPUT_NUMBER);
    }

    /**
     * print massage after print array
     *
     */
    private void printAftreInputArray(){
        view.print(textStrings.SEPARATE_LINE);
        printEnterInt();
        view.print(textStrings.EXIT);
    }
}
