import java.util.HashMap;
import java.util.Map;

public class Bag<T> {
    private Map<T, Integer> items;

    public Bag() {
        items = new HashMap<>();
    }

    // Adds to the bag
    public void add(T item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    // Removes from the bag
    public void remove(T item) {
        if (contains(item)) {
            int count = items.get(item);
            if (count > 1) {
                items.put(item, count - 1);
            } else {
                items.remove(item);
            }
        }
    }

    // Checks an item in the bag
    public boolean contains(T item) {
        return items.containsKey(item);
    }

    // Gets count of an item in the bag
    public Bag<T> getCount(T item) {
        int count = items.getOrDefault(item, 0);
        System.out.println(item + ": " + count);
        return this;
    }

    // Prints contents
    public void printContents() {
        System.out.println("Bag Contents:");
        for (Map.Entry<T, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Defines size
    public int size() {
        return items.size();
    }
    
    // Easily called size print method
    public void printSize() {
        System.out.println("Bag Size: " + size());
    }    

    // Method to merge another bag into the current bag
    public void merge(Bag<T> otherBag) {
        for (T item : otherBag.items.keySet()) {
            int count = otherBag.items.get(item);
            items.put(item, items.getOrDefault(item, 0) + count);
        }
    }

    // Method to return a new bag with only distinct elements
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();
        for (T item : items.keySet()) {
            distinctBag.add(item); // Add each item once to the new bag
        }
        return distinctBag;
    }

}
