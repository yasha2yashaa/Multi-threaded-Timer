package helpers;

public class Timer implements Runnable {

    private int secondCounter = 0;
    private boolean isRunning = true;
    private Thread thread;

    @Override
    public void run() {
        thread = Thread.currentThread();
        try {
            while(!thread.isInterrupted()) {
                if(isRunning) {
                        Thread.sleep(1000);
                        secondCounter++;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSecondCounter() {
        return  secondCounter;
    }

    public long getThreadId() {
        return thread.getId();
    }

    public void pause() {
        isRunning = false;
    }

    public void unpause() {
        isRunning = true;
    }

    public void interrupt() {
        thread.interrupt();
    }
}
