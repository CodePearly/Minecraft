import java.util.Scanner;

public class OptionChooser {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Display the options to the user
        System.out.println("Please choose an option:");
        System.out.println("1. Option 1");
        System.out.println("2. Option 2");

        // Read the user's input
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        // Determine the output based on the user's choice
        if (choice == 1) {
            System.out.println("You chose Option 1.");
        } else if (choice == 2) {
            System.out.println("You chose Option 2.");
        } else {
            System.out.println("You did not choose a valid option.");
        }

        // Close the scanner
        scanner.close();
    }
}
