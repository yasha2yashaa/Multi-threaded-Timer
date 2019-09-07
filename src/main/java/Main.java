import controllers.ApplicationController;
import helpers.InputTaker;
import helpers.TimersContainer;
import services.ApplicationService;
import view.ThreadInfoPrinter;

public class Main {
    public static void main(String[] args) {
        printApplicationInfo();

        TimersContainer timersContainer = new TimersContainer();
        ThreadInfoPrinter threadInfoPrinter = new ThreadInfoPrinter();
        ApplicationService applicationService = new ApplicationService(timersContainer, threadInfoPrinter);
        InputTaker inputTaker = new InputTaker();
        ApplicationController applicationController = new ApplicationController(applicationService, inputTaker);

        applicationController.start();
    }

    private static void printApplicationInfo() {
        String info =
                "Multithreaded timer app\n"
                + "Type \"start <timer_name>\", \"stop <timer_name>\", \"remove <timer_name>\">,"
                + " \"show\" and \"exit\" to use the application";
        System.out.println(info);
    }
}
