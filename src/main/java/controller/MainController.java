package controller;

import entities.Author;
import entities.Book;
import entities.Publisher;
import entities.abstracts.BookList;
import model.Model;
import org.apache.log4j.Logger;
import utility.Generator;
import static  utility.TextStrings.*;
import view.Messenger;

import java.io.*;


import static utility.TextStrings.EXIT;

public class MainController {
    static Logger logger = Logger.getLogger(MainController.class);
    private Model model;
    private Messenger view;
    private Generator base;


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
        view.print(GENERATE_FINISH);
        printMainInfo();

        while ((readValue = reader.readLine()) != null){
            if (readValue.equals(EXIT)) {
                logger.info("Exit");
                break;
            }else  if (readValue.equals(PRINT)) {
                printAll();
            }else  if (readValue.equals(AUTHOR_BOOKS)) {
                logger.info("Print authors book");
                printListBook(base.getAuthors());
            }else  if (readValue.equals(PUBLISHER_BOOKS)) {
                logger.info("Print publisher book");
                printListBook(base.getPublishers());
            }else  if (readValue.equals(LESS_YEAR)) {
                logger.info("Print books less then");
                yearBook();
            }else  if (readValue.equals(SORT)) {
                logger.info("Sort books");
                sortBook();
            }else if (readValue.equals(SAVE)){
                logger.info("Save books: start");
                saveBook();
                logger.info("Save books: finish");
            }else if (readValue.equals(LOAD)){
                logger.info("Load books: start");
                loadBook();
                logger.info("Load books: finish");
            }else{
                logger.info("Wrong input:" + readValue);
                printMainInfo();
            }
        }

        reader.close();
    }

    private void saveBook(){
        view.print(INPUT_FILE_NAME);
        view.print(EXIT_STRING);
        File file = null;
        boolean stopWork = false;
        do {
            try {
                view.print(INPUT_FILE_NAME);
                view.print(EXIT_STRING);
                readValue = reader.readLine();
                file = new File(readValue);

                if(readValue.equals(EXIT)){
                    logger.info("exit by user " + readValue);
                    printMainInfo();
                    return;
                }

                if (!file.exists()) {
                    file.createNewFile();
                }
                    stopWork = true;

            } catch (IOException e) {
                logger.info(e.getMessage());
                view.print(e.getMessage());
            }
        }while (!stopWork);

        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
                oos.writeObject(base.getBooks());
                logger.info("write books");
                oos.writeObject(base.getAuthors());
                logger.info("write authors");
                oos.writeObject(base.getPublishers());
                logger.info("write publishers");

        } catch (IOException e) {
            logger.debug(e.getMessage());
        }

        printMainInfo();
    }


    private void loadBook() {

        File file = null;
        boolean stopWork = false;
        do {
            try {
                view.print(INPUT_FILE_NAME);
                view.print(EXIT_STRING);
                readValue = reader.readLine();
                file = new File(readValue);

                if(readValue.equals(EXIT)){
                    logger.info("exit by user " + readValue);
                    printMainInfo();
                    return;
                }
                stopWork = file.exists();
                if(!stopWork){
                    view.print(INPUT_FILE_NAME);
                    logger.info("wrong file name: " + readValue);
                }

            } catch (IOException e) {
                logger.info(e.getMessage());
            }
        }while (!stopWork);

        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            Book[] newBook = (Book[]) ois.readObject();
            logger.info("read books");
            Author[] newAuthors = (Author[]) ois.readObject();
            logger.info("read authors");
            Publisher[] newPublishers = (Publisher[]) ois.readObject();
            logger.info("read publishers");
            if(newBook == null || newAuthors == null || newPublishers == null){
                throw new IOException("not all data read. New data didn't load");
            }
            base.setBooks(newBook);
            base.setAuthors(newAuthors);
            base.setPublishers(newPublishers);
        } catch (ClassNotFoundException|IOException e) {
            logger.debug(e.getMessage());

        }

        printMainInfo();
    }



    private void printAll() {
        logger.info("Print all books");
        view.printInputArray(base.getBooks());
        printMainInfo();
    }

    private void printListBook(BookList[] inputList) throws IOException{
        view.printInputArray(inputList);
        printAftreInputArray();
        view.print(ITEM_LIST);
        while ((readValue = reader.readLine()) != null){
            if(readValue.equals(EXIT)) {
                logger.info("Exit from printing list by author or publisher");
                printMainInfo();
                break;
            }
            if(readValue.equals(ITEMLIST)) {
                view.printInputArray(inputList);
                printAftreInputArray();
                view.print(ITEM_LIST);
                continue;
            }
            int number = 0;
            try {
                number = Integer.parseInt(readValue);
                BookList bookList = model.getObjFromArray(inputList, number - 1);
                if(bookList == null){
                    logger.info("no books in list ");
                    printErrorNumberInfo();
                    printEnterInt();
                    continue;
                }
                view.printInputArrayList(bookList.getBookList());
                printEnterInt();

            } catch (NumberFormatException e) {
                logger.info("wrong input " + e.toString());
                printErrorNumberInfo();
                printEnterInt();
            }
        }

    }

    private void yearBook() throws IOException {
       printEnterInt();
        while ((readValue = reader.readLine()) != null){
            if(readValue.equals(EXIT)) {
                logger.info("Exit from printing less year book");
                printMainInfo();
                break;
            }
            int number = 0;
            try {
                number = Integer.parseInt(readValue);
                Book[] books = model.filterByYear(base.getBooks(), number);
                if(books == null){
                    logger.info("no books in list ");
                    printErrorNumberInfo();
                    printEnterInt();
                    continue;
                }
                view.printInputArray(books);
                printAftreInputArray();

            } catch (NumberFormatException e) {
                logger.info("wrong input " + e.toString());
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
        view.print(SEPARATE_LINE);
        view.print(MENU);
        view.print(EXIT_STRING);
    }

    /**
     * print massage about error
     *
     */
    private void printErrorNumberInfo(){
        view.print(INVALID_NUMBER);
        view.print(EXIT_STRING);
    }

    /**
     * print massage about input int
     *
     */
    private  void printEnterInt(){
        view.print(INPUT_NUMBER);
    }

    /**
     * print massage after print array
     *
     */
    private void printAftreInputArray(){
        view.print(SEPARATE_LINE);
        printEnterInt();
        view.print(EXIT_STRING);
    }
}
