package utility;

public interface TextStrings {

    String EXIT = "-ext";
    String PRINT = "-prt";
    String AUTHOR_BOOKS = "-aut";
    String PUBLISHER_BOOKS = "-pub";
    String LESS_YEAR = "-yea";
    String SORT = "-srp";
    String SAVE = "-save";
    String LOAD = "-load";
    String ITEMLIST = "-ite";


    String EXIT_STRING = "Exit " +EXIT;
    String ITEM_LIST = "List of items " + ITEMLIST;
    String INVALID_NUMBER = "Invalid number entered";
    String SEPARATE_LINE = "-----------------------------------------";
    String MENU = "Print all books "+PRINT+"\n" +
            "Books of author "+AUTHOR_BOOKS+"\n" +
            "Books from publisher "+PUBLISHER_BOOKS+"\n" +
            "Books after year "+ LESS_YEAR +"\n" +
            "Sort by publisher "+SORT+"\n" +
            "Save list of books " + SAVE +"\n" +
            "Load list of books " + LOAD;

    String GENERATE_DATA = "Generating data";
    String GENERATE_FINISH = "Generation finished";
    String INPUT_NUMBER ="Enter positive number";

    String INPUT_FILE_NAME = "Input path to file";




}
