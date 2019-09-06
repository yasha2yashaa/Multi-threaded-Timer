import controllers.ApplicationController;
import helpers.InputTaker;
import helpers.TimersContainer;
import services.ApplicationService;
import view.ThreadInfoPrinter;

public class Main {
    public static void main(String[] args) {
        TimersContainer timersContainer = new TimersContainer();
        ThreadInfoPrinter threadInfoPrinter = new ThreadInfoPrinter();
        ApplicationService applicationService = new ApplicationService(timersContainer, threadInfoPrinter);
        InputTaker inputTaker = new InputTaker();
        ApplicationController applicationController = new ApplicationController(applicationService, inputTaker);

        applicationController.start();
    }
}
