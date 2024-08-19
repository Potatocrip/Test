public class bagTest {
    public static void main(String[] args) {
        // Creates a bag
        Bag<String> myBag = new Bag<>();

        // Adds elements to the bag
        myBag.add("apple");
        myBag.add("banana");
        myBag.add("apple");
        myBag.add("orange");
        myBag.add("banana");
        myBag.add("apple");

        // Prints contents
        myBag.printContents();

        // Checks for an orange and apple 
        System.out.println("\nDoes the bag contain 'orange'? " + myBag.contains("orange"));
        System.out.println("\nDoes the bag contain 'apple'? " + myBag.contains("apple"));

        // Gets count
        System.out.println("\nGetting counts for multiple items:");
        myBag.getCount("apple").getCount("orange");

        // Removes an orange
        System.out.println("\nRemoving an 'orange'...");
        myBag.remove("orange");

	// Prints again
        myBag.printContents();

        // Checks again to make sure orange was removed
        System.out.println("\nDoes the bag contain 'orange'? " + myBag.contains("orange"));

        // Gets count for orange
        System.out.println("\nGetting count for orange:");
        myBag.getCount("orange");
    }
}
