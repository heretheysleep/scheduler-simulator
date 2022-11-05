import java.util.Vector;

public class OperationalSystem {
    private int queueLength;
    private Vector<Process> processQueue;
    private int numberOfWaitingProcess;
    private int nextProcessIndex;

    public OperationalSystem(int queueLength) {
        this.queueLength = queueLength;
        processQueue = new Vector<Process>(queueLength);
        numberOfWaitingProcess = 0;
        nextProcessIndex = 0;
    }

    public boolean queueIsEmpty() {
        return numberOfWaitingProcess == 0;
    }

    public boolean queueIsFull() {
        return numberOfWaitingProcess == queueLength;
    }

    public boolean addProcess() {
        int endOfQueue = (numberOfWaitingProcess + nextProcessIndex) % queueLength;

        if (queueIsFull()) {
            System.out.println("\nInvalid action: process queue is full");

            return false;
        }

        processQueue.add(endOfQueue, new Process());
        numberOfWaitingProcess++;

        return true;
    }

    public Process executeProcess() {
        Process executedProcess;

        if (queueIsEmpty()) {
            System.out.println("\nOops! The scheduler didn't find any processes in the queue");

            return null;
        }

        executedProcess = processQueue.get(nextProcessIndex);
        
        numberOfWaitingProcess--;
        nextProcessIndex = (nextProcessIndex + 1) % queueLength;

        return executedProcess;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
