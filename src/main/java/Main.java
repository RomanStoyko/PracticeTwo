import controller.MainController;
import view.Messenger;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{

        Messenger.beforGen();
        MainController mainController = new MainController();
        mainController.work();
    }
}
