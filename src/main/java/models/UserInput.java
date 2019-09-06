package models;

public class UserInput {

    private final String input;

    public UserInput(String input) {
        this.input = input;
    }

    public boolean isExitRequest() {
        return input.equalsIgnoreCase("exit");
    }

    public boolean isShowRequest() {
        return input.equalsIgnoreCase("show");
    }

    public boolean isStartRequest() {
        return input.toLowerCase().startsWith("start");
    }

    public boolean isStopRequest() {
        return input.toLowerCase().startsWith("stop");
    }

    public String getTimerName() {
        if (isRequestTypeWithTimerName()) {
            return input.split(" ")[1];
        }
        else {
            throw new IllegalStateException("Input is not a start or stop request, it doesn't contain timer name.");
        }
    }

    private boolean isRequestTypeWithTimerName() {
        return isStartRequest() || isStopRequest();
    }
}
