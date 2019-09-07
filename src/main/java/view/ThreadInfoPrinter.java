package view;

import helpers.Timer;
import helpers.TimersContainer;

import java.util.Set;

public class ThreadInfoPrinter {
    public void print(TimersContainer timersContainer) {
        Set<String> timerNames = timersContainer.getTimerNames();
        Timer timer;
        for (String timerName: timerNames) {
            timer = timersContainer.get(timerName);
            print("Name: ");
            print(timerName);
            print(", ThreadId: ");
            print(timer.getThreadId());
            print(", Seconds: ");
            print(timer.getSecondCounter());
        }
    }

    private void print(String string) {
        System.out.print(string);
    }

    private void print(long number) {
        System.out.print(number);
    }

    private void print(int number) {
        System.out.println(number);
    }
}
