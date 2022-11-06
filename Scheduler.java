public class Scheduler {
    private int queueLength;
    private Process[] processQueue;
    private int numberOfWaitingProcess;
    private int nextProcessIndex;

    public Scheduler(int queueLength) {
        this.queueLength = queueLength;
        processQueue = new Process[queueLength];
        numberOfWaitingProcess = 0;
        nextProcessIndex = 0;
    }

    public boolean queueIsEmpty() {
        return numberOfWaitingProcess == 0;
    }

    public boolean queueIsFull() {
        return numberOfWaitingProcess == queueLength;
    }

    public boolean addProcess(Process process) {
        int endOfQueue = (numberOfWaitingProcess + nextProcessIndex) % queueLength;

        if (queueIsFull()) {
            System.out.println("\nInvalid action: process queue is full.");

            return false;
        }

        processQueue[endOfQueue] = process;
        numberOfWaitingProcess++;

        System.out.println("\nAction status: SUCCESSFUL\nProcess is waiting.");
        process.printPID();

        return true;
    }

    public Process executeProcess() {
        Process executedProcess;

        if (queueIsEmpty()) {
            System.out.println("\nOops! The scheduler didn't find any processes in the queue.");

            return null;
        }

        executedProcess = processQueue[nextProcessIndex];
        
        nextProcessIndex = (nextProcessIndex + 1) % queueLength;
        numberOfWaitingProcess--;

        System.out.println("\nAction status: SUCCESSFUL\nProcess executed.");
        executedProcess.printPID();

        return executedProcess;
    }
}
