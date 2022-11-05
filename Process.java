import java.util.Random;

public class Process {
    private final String PID;

    public Process() {
        PID = generatePID();
    }

    private String generatePID() {
        String randomicValue = null;
        Random generator = new Random();

        randomicValue = String.format("%04d", generator.nextInt(10000));

        return randomicValue;
    }

    public void printPID() {
        System.out.println("Process Identifier (PID): " + PID);
    }
}
