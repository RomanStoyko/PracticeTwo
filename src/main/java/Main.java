import controller.MainController;
import model.Model;
import utility.Generator;
import utility.TextStrings;
import view.Messenger;

import java.io.IOException;

public class Main {

    private static TextStrings textStrings;

    public static void main(String[] args) throws IOException{
        Model model = new Model();
        Messenger view = new Messenger();

        view.print(textStrings.GENERATE_DATA);
        Generator generator = new Generator();
        MainController mainController = new MainController(model,view,generator);
        mainController.work();
    }
}
