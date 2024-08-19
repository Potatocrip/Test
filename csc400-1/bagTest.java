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

        // Checks if bag contains certain elements
        System.out.println("\nDoes the bag contain 'orange'? " + myBag.contains("orange"));
        System.out.println("Does the bag contain 'grape'? " + myBag.contains("grape"));

        // Gets counts of a few elements
        String targetItem = "apple";
        int count = myBag.getCount(targetItem);
        System.out.println("Count of '" + targetItem + "': " + count);

        String targetItem = "orange";
        int count = myBag.getCount(targetItem);
        System.out.println("Count of '" + targetItem + "': " + count);

        // Removes an orange
        System.out.println("\nRemoving a 'banana'...");
        myBag.remove("orange");

	// Prints again
        myBag.printContents();

        // Checks again to make sure orange was removed
        System.out.println("\nDoes the bag contain 'orange'? " + myBag.contains("orange"));

    }
}
