import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

class Automobile {
    private String make, model, color;
    private int year, mileage;
    // Assigns vars to Automobile class
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make; this.model = model; this.color = color;
        this.year = year; this.mileage = mileage;
    }
    // Get and set vars
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getColor() { return color; }
    public int getYear() { return year; }
    public int getMileage() { return mileage; }

    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setColor(String color) { this.color = color; }
    public void setYear(int year) { this.year = year; }
    public void setMileage(int mileage) { this.mileage = mileage; }
}

class Dealership {
    // Creates inventory list
    private List<Automobile> inventory = new ArrayList<>();
    // Calls addVehicle func from Automobile class
    public void addVehicle(Automobile vehicle) { inventory.add(vehicle); }
    // Uses Iterator to loop through inventory list and remove if 'make' and 'model' match the user input
    public void removeVehicle(String make, String model) {
        Iterator<Automobile> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Automobile vehicle = iterator.next();
            if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)) {
                iterator.remove();
                System.out.println("Vehicle " + make + " " + model + " removed from inventory.");
                return;
            }
        }
        System.out.println("Vehicle " + make + " " + model + " not found in inventory.");
    }
    // Uses Scanner to receive user input, loops to matching entry in list, sets new values
    public void updateVehicle(String make, String model) {
        Scanner scanner = new Scanner(System.in);
        for (Automobile vehicle : inventory) {
            if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)) {
                System.out.println("Which attribute do you want to update?");
                System.out.println("1. Make\n2. Model\n3. Color\n4. Year\n5. Mileage");
                int choice = getIntInput(scanner, "Invalid choice. Please enter a number between 1 and 5.", 1, 5);
                if (choice == -1) return;

                switch (choice) {
                    case 1: vehicle.setMake(scanner.nextLine()); break;
                    case 2: vehicle.setModel(scanner.nextLine()); break;
                    case 3: vehicle.setColor(scanner.nextLine()); break;
                    case 4: vehicle.setYear(getIntInput(scanner, "Invalid input. Please enter a valid year.", Integer.MIN_VALUE, Integer.MAX_VALUE)); break;
                    case 5: vehicle.setMileage(getIntInput(scanner, "Invalid input. Please enter a valid mileage.", Integer.MIN_VALUE, Integer.MAX_VALUE)); break;
                }
                System.out.println("Vehicle attributes updated successfully.");
                return;
            }
        }
        System.out.println("Vehicle " + make + " " + model + " not found in inventory.");
    }
    // Catches invalid int inputs
    private int getIntInput(Scanner scanner, String errorMessage, int min, int max) {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            if (input < min || input > max) throw new NumberFormatException();
            return input;
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            return -1;
        }
    }
    // Loops through entire inventory, prints vars for each vehicle in inventory
    public void displayInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            Automobile vehicle = inventory.get(i);
            System.out.printf("%d. Make: %s, Model: %s, Color: %s, Year: %d, Mileage: %d%n",
                    i + 1, vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getYear(), vehicle.getMileage());
        }
    }
    // Uses FileWriter to create new .txt file and loop through inventory, writing vars for each vehicle in inventory to the file
    public void saveToFile(String filename) {
        try (FileWriter fileWriter = new FileWriter(filename + ".txt")) {
            for (Automobile vehicle : inventory) {
                fileWriter.write(String.format("Make: %s, Model: %s, Color: %s, Year: %d, Mileage: %d%n",
                        vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getYear(), vehicle.getMileage()));
            }
            System.out.println("Inventory saved to " + filename + ".txt");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Dealership dealership = new Dealership();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:\n1. Add a new vehicle\n2. Remove a vehicle\n3. Update vehicle attributes\n4. Display inventory\n5. Save inventory to a file\n6. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            // Uses Scanner to receive user input, calls respective funcs with vars assigned by user input
            switch (choice) {
                case "1":
                    addVehicle(dealership, scanner); break;
                case "2":
                    System.out.print("Enter make of the vehicle to remove: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter model of the vehicle to remove: ");
                    String model = scanner.nextLine();
                    dealership.removeVehicle(make, model);
                    break;
                case "3":
                    System.out.print("Enter make of the vehicle to update: ");
                    make = scanner.nextLine();
                    System.out.print("Enter model of the vehicle to update: ");
                    model = scanner.nextLine();
                    dealership.updateVehicle(make, model);
                    break;
                case "4":
                    System.out.println("\nInventory:");
                    dealership.displayInventory();
                    break;
                case "5":
                    System.out.print("Enter filename to save inventory: ");
                    String filename = scanner.nextLine();
                    dealership.saveToFile(filename);
                    break;
                case "6":
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    // Uses Scanner to receive user input, assigns to vars and adds to new vehicle in inventory
    private static void addVehicle(Dealership dealership, Scanner scanner) {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        int year = getIntInput(scanner, "Enter year: ", "Invalid input for year. Please enter a valid number.");
        int mileage = getIntInput(scanner, "Enter mileage: ", "Invalid input for mileage. Please enter a valid number.");
        if (year == -1 || mileage == -1) return;
        dealership.addVehicle(new Automobile(make, model, color, year, mileage));
        System.out.println("Vehicle added successfully.");
    }
    // Catches invalid int inputs
    private static int getIntInput(Scanner scanner, String prompt, String errorMessage) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            return -1;
        }
    }
}
