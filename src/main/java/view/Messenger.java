package view;

import entities.Book;

import java.util.List;

/**
 * class what print all massages
 */
public class Messenger {

    /**
     * printing mwthod for all strings
     * @param string - some string
     */
    public void print(String string){
        System.out.println(string);
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


}
