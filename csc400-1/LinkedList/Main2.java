import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        // txt file name
        String fileName = "data.txt";

        // New instance of Scanner using file of fileName, parses line by line
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    int data = Integer.parseInt(line.trim());  // Converts the line to an integer
                    linkedList.insert(data); // Inserts parsed data
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid integer: " + line);  // If it can't convert to valid int, skips the line
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName); // If it can't find the file, throws an error
        }

        // Displays elements in the linked list
        System.out.print("List after reading from file: ");
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
