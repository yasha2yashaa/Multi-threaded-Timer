package services;

import helpers.Timer;
import helpers.TimersContainer;
import view.ThreadInfoPrinter;

import java.util.Set;

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
           Thread thread = new Thread(timer);
           thread.start();
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

    public void remove(String timerName) {
        if (timersContainer.exists(timerName)) {
            Timer timer = timersContainer.get(timerName);
            timer.interrupt();
            timersContainer.remove(timerName);
        }
    }

    public void interruptAllTimerThreads() {
        Set<String> timerNames = timersContainer.getTimerNames();
        timerNames.forEach(string -> timersContainer.get(string).interrupt());
    }
}
