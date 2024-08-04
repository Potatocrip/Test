import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Comparator;
import java.io.IOException;

class Vehicle {
    private String make;
    private String model;
    private double milesPerGallon;

    // Vehicle object with constructor & toString for easy printing

    public Vehicle(String make, String model, double milesPerGallon) {
        this.make = make;
        this.model = model;
        this.milesPerGallon = milesPerGallon;
    }

    public double getMilesPerGallon() {
        return milesPerGallon;
    }

    @Override
    public String toString() {
        return "Make: " + make + ", Model: " + model + ", MPG: " + milesPerGallon;
    }
}

class MilesPerGallonComparator implements Comparator<Vehicle> {
    
    // Compares two Vehicle objects based on mpg in ascending order
    
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return Double.compare(v1.getMilesPerGallon(), v2.getMilesPerGallon());
    }
}

public class vehicleList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Vehicle> vehicles = new LinkedList<>();

        while (true) {
            System.out.print("Enter vehicle make (or 'exit' to finish): ");
            String make = scanner.nextLine();
            if (make.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter vehicle model: ");
            String model = scanner.nextLine();

            System.out.print("Enter vehicle miles per gallon: ");
            double milesPerGallon = scanner.nextDouble();
            scanner.nextLine(); // consume the newline character

            Vehicle vehicle = new Vehicle(make, model, milesPerGallon);
            vehicles.add(vehicle);
        }

        mergeSort(vehicles, new MilesPerGallonComparator());

        System.out.println("\nVehicles entered (sorted by MPG):");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        scanner.close();
    }

    public static void mergeSort(LinkedList<Vehicle> list, Comparator<Vehicle> comparator) {
        if (list.size() <= 1) {
            return;
        }

        // Recursively divides ArrayList into two halves, 'left' and 'right', until reaching the base case

        int mid = list.size() / 2;
        LinkedList<Vehicle> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<Vehicle> right = new LinkedList<>(list.subList(mid, list.size()));

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(list, left, right, comparator);
    }

    private static void merge(LinkedList<Vehicle> list, LinkedList<Vehicle> left, LinkedList<Vehicle> right, Comparator<Vehicle> comparator) {
        int i = 0, j = 0, k = 0;

        // Recursively compares & merges lists

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    private static void writeToFile(LinkedList<Vehicle> vehicles, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Vehicle vehicle : vehicles) {
                writer.write(vehicle.toString() + "\n");
            }
            System.out.println("Vehicles written to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}