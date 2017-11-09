package view;

import entities.Book;

import java.util.List;

/**
 * class what print all massages
 */
public class Messenger {

    public static void beforGen(){
        System.out.println("Начата генерация данных");
    }

    public void afterGen(){
        System.out.println("Данные подготовленны");

    }
    /**
     * print main info
     */
    public void mainInfo(){
        System.out.println("-----------------------------------");
        System.out.println("Print all books -prt");
        System.out.println("Books of author -aut");
        System.out.println("Books from publisher -pub");
        System.out.println("Books after year -yea");
        System.out.println("Sort by publisher -srp");
        System.out.println("Exit -ext");
    }

    /**
     * print array
     * @param result array
     */
    public <T> void printInputArray(T[] result){

        for(int i = 0; i < result.length; i++){
            if (result[i] == null){
                continue;
            }
            int num = i + 1;
            System.out.println(num + ". " +  result[i]);
        }
        System.out.println("-----------------------------------------");
        printEnterInt();
        System.out.println("List of items -ite");
        System.out.println("Exit -ext");
    }

    /**
     * print array
     * @param result array
     */
    public  void printInputArray(Book[] result){

        for (Book aResult : result) {
            if (aResult == null) {
                continue;
            }
            System.out.println(aResult);
        }

    }

    public void printAftreInputArray(){
        System.out.println("-----------------------------------------");
        printEnterInt();
        System.out.println("Exit -ext");
    }
    /**
     * print arrayList
     * @param result arrayList
     */
    public <T> void printInputArrayList(List<T> result){

        for (T aResult : result) {
            if (aResult == null) {
                continue;
            }
            System.out.println(aResult);
        }
    }

    /**
     * print of error number input
     */
    public void printErrorNumberInfo(){
        System.out.println("Invalid number entered");
        System.out.println("Exit -ext");
    }

    /**
     * print massage about input int
     *
     */
    public  void printEnterInt(){
        System.out.println("Enter positive number" );
    }


//    /**
//     * print some text when answer not available
//     */
//    private  void printNoResult(){
//        System.out.println("Входящие данные не соответствуют условиям! Результат неопределен!");
//        System.out.println("-----------------------------------------------------------------");
//    }


    //    /**
//     * printing event info
//     * name - string name of event converted ro upper case
//     * @param name string name of event converted ro upper case
//     *
//     */
//    public static void printEventInfo(String name){
//        System.out.println("-----------------------------------");
//        System.out.println(name.toUpperCase());
//        System.out.println("Для выхода введите -ext");
//        System.out.println("-----------------------------------");
//    }
}
