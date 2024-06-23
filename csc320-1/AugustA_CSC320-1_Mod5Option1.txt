import java.util.Scanner;

public class DailyTemperatures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Stores days of week and temperatures for each day in arrays
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        double[] temperatures = new double[7];

        // Prompts and waits for user input, assigns to each 'i' in array
        for (int i = 0; i < daysOfWeek.length; i++) {
            System.out.print("Enter temperature for " + daysOfWeek[i] + ": ");
            temperatures[i] = scanner.nextDouble();
        }

        // Prompts and waits for user input
        System.out.print("Enter the day of the week or 'week' for weekly average: ");
        String input = scanner.next();

        // Displays temperature based on user input
        if (input.equalsIgnoreCase("week")) {
            double sum = 0;
            for (double temp : temperatures) {
                sum += temp;
            }
            double average = sum / temperatures.length;

            // Displays daily temperatures
            System.out.println("Daily Temperatures:");
            for (int i = 0; i < daysOfWeek.length; i++) {
                System.out.println(daysOfWeek[i] + ": " + temperatures[i]);
            }

            // Displays weekly average temperature
            System.out.println("Weekly Average Temperature: " + average);
        } else {
            boolean found = false;
            for (int i = 0; i < daysOfWeek.length; i++) {
                if (input.equalsIgnoreCase(daysOfWeek[i])) {
                    System.out.println("Temperature for " + daysOfWeek[i] + ": " + temperatures[i]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid input. Please enter a valid day of the week or 'week'.");
            }
        }

        scanner.close();
    }
}
