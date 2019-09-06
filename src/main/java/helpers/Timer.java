package helpers;

public class Timer implements Runnable {

    private int secondCounter = 0;
    private boolean isRunning = true;
    private Timer timer;

    @Override
    public void run() {
//        try {
//
//        } catch(InterruptedException e) {
//            // interrupted
//        }
    }

    public void pause() {
        isRunning = false;
    }

    public void unpause() {
        isRunning = true;
    }

    public void interrupt() {
    }
}
