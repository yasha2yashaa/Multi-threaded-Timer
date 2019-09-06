package services;

import helpers.TimersContainer;
import view.ThreadInfoPrinter;

public class ApplicationService {
    private ThreadInfoPrinter threadInfoPrinter;
    private TimersContainer timersContainer;

    public ApplicationService(TimersContainer timersContainer, ThreadInfoPrinter threadInfoPrinter) {
        this.timersContainer = timersContainer;
        this.threadInfoPrinter = threadInfoPrinter;
    }

    public void show() {
    }

    public void startNewTimer(String timerName) {

    }

    public void pauseTimer(String timerName) {

    }
}
