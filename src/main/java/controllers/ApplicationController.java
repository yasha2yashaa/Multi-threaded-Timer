package controllers;

import helpers.InputTaker;
import models.UserInput;
import services.ApplicationService;

public class ApplicationController {
    private ApplicationService applicationService;
    private InputTaker inputTaker;
    private boolean run;

    public ApplicationController(ApplicationService applicationService, InputTaker inputTaker) {
        this.applicationService = applicationService;
        this.inputTaker = inputTaker;
    }

    public void start() {
        run = true;
        UserInput input;
        while (run) {
            input = inputTaker.getUserInput();
            if (input.isExitRequest()) {
                exit();
            }
            else if (input.isShowRequest()) {
                show();
            }
            else if (input.isStartRequest()) {
                start(input.getTimerName());
            }
            else if (input.isStopRequest()) {
                stop(input.getTimerName());
            }
            else if (input.isRemoveRequest()) {
                remove(input.getTimerName());
            }
            else {
                System.out.println("Invalid keyword");
            }
        }
    }

    private void exit() {
        run = false;
        show();
        applicationService.interruptAllTimerThreads();
    }

    private void show() {
        applicationService.show();
    }

    private void start(String timerName) {
        applicationService.startNewTimer(timerName);
    }

    private void stop(String timerName) {
        applicationService.pauseTimer(timerName);
    }

    private void remove(String timerName) {
        applicationService.remove(timerName);
    }
}
