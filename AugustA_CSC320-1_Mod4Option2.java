import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Stores 10 grades with which to make calculations
        double[] grades = new double[10];
        
        // Prompts and waits for user input, assigns to each 'i' in array
        System.out.println("Enter 10 grades:");
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Grade " + (i + 1) + ": ");
            // Checks if the input is a valid double
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Discards invalid input
            }
            grades[i] = scanner.nextDouble();
        }
        scanner.close(); 
        
        // Calculates average of all grades in array
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / 10;
        
        // Finds maximum grade in array
        double maxGrade = grades[0];
        for (double grade : grades) {
            if (grade > maxGrade) {
                maxGrade = grade;
            }
        }
        
        // Finds minimum grade in array
        double minGrade = grades[0];
        for (double grade : grades) {
            if (grade < minGrade) {
                minGrade = grade;
            }
        }
        
        // Prints final calculations
        System.out.println("Average grade: " + average);
        System.out.println("Maximum grade: " + maxGrade);
        System.out.println("Minimum grade: " + minGrade);
    }
}