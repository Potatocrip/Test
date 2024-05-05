import java.util.Scanner;

public class TaxCalculator {

    // Function to calculate tax rate based on weekly income
    public static double getTaxRate(double weeklyIncome) {
        if (weeklyIncome < 500) {
            return 0.10; // 10%
        } else if (weeklyIncome < 1500) {
            return 0.15; // 15%
        } else if (weeklyIncome < 2500) {
            return 0.20; // 20%
        } else {
            return 0.30; // 30%
        }
    }
    // Main function
    public static void main(String[] args) {
        // Opens scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompts user for their weekly income
        System.out.print("Enter your weekly income: ");
        double weeklyIncome = scanner.nextDouble();
        // Closes scanner
        scanner.close();

        // Invokes getTaxRate using given weekly income
        double taxRate = getTaxRate(weeklyIncome);

        // Calculates tax withholding
        double taxWithholding = weeklyIncome * taxRate;

        // Displays final results
        System.out.println("Weekly Income: $" + weeklyIncome);
        System.out.println("Applicable Tax Rate: " + (taxRate * 100) + "%");
        System.out.println("Weekly Tax Withholding: $" + taxWithholding);
    }
}
