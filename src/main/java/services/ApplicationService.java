package services;

import helpers.Timer;
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
        threadInfoPrinter.print(timersContainer);
    }

    public void startNewTimer(String timerName) {
        Timer timer;
        if (!timersContainer.exists(timerName)) {
           timer = new Timer();
           timer.run();
           timersContainer.add(timerName, timer);
        }
        else {
            timer = timersContainer.get(timerName);
            timer.unpause();
        }
    }

    public void pauseTimer(String timerName) {
        if (timersContainer.exists(timerName)) {
            Timer timer = timersContainer.get(timerName);
            timer.pause();
        }
    }
}
