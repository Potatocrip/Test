import java.util.Comparator;

class Vehicle {
    private String make;
    private String model;
    private double milesPerGallon;

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
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return Double.compare(v1.getMilesPerGallon(), v2.getMilesPerGallon());
    }
}
