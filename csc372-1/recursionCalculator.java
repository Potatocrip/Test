import java.util.InputMismatchException;
import java.util.Scanner;

public class recursionCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 5 whole numbers! (Either one number at a time or all at once, separated by spaces!)");

        int sum = getSum(scanner, 1, 5);
        System.out.println("\nThe sum of the five given numbers is: " + sum);
    }

    public static int getSum(Scanner scanner, int current, int total) {
        if (current > total) {
            return 0;
        } else {
            int number = 0;
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter number " + current + ": ");
                try {
                    number = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid! Please enter an integer.");
                    scanner.next();
                }
            }
            return number + getSum(scanner, current + 1, total);
        }
    }
}
