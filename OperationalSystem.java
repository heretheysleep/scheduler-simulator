import java.util.Scanner;

public class OperationalSystem {
    private Scanner scanner;
    private Scheduler scheduler;

    public OperationalSystem(Scheduler scheduler) {
        scanner = new Scanner(System.in);
        this.scheduler = scheduler;
    }

    public void run() {
        int option = 0;

        System.out.println("Welcome to BSI-OS\nPlease, choice an option");

        while (true) {
            System.out.println("\n(1) Add process\n(2) Execute process\n(3) Turn off\n\nOption:");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
                System.out.println("\nError: invalid input\nTry again");

                continue;
            }

            switch (option) {
                case 1:
                    scheduler.addProcess(new Process());
                    break;
                case 2:
                    scheduler.executeProcess();
                    break;

                case 3:
                    System.out.println("\nSee you soon.");
                    return;

                default:
                    System.out.println("\nError: invalid option\nTry again");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler(5);
        OperationalSystem operationalSystem = new OperationalSystem(scheduler);

        operationalSystem.run();
    }
}
