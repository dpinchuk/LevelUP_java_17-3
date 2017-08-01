package home.task5;

public class QueueException extends Exception {

    private String threadName;
    private String message;

    public QueueException(String threadName, String message) {
        super(message);
        this.message = message;
        this.threadName = threadName;
    }

    public synchronized String getMessage() {
        return "Thread #" + this.threadName + " -> " + this.message;
    }
}