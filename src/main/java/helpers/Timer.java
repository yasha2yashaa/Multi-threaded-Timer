package helpers;

public class Timer implements Runnable {

    private int secondCounter = 0;
    private boolean isRunning = true;
    private Thread thread;

    @Override
    public void run() {
//        try {
//            thread = Thread.currentThread();
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
