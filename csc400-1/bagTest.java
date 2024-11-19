public class BagTest {
    public static void main(String[] args) {
        // Creates bags
        Bag<String> myBag = new Bag<>();
        Bag<String> otherBag = new Bag<>();

        // Adds elements to the bag
        myBag.add("apple");
        myBag.add("banana");
        myBag.add("apple");
        myBag.add("orange");
        myBag.add("banana");
        myBag.add("apple");

        otherBag.add("grape");
        otherBag.add("strawberry");
        otherBag.add("grape");
        otherBag.add("strawberry");
        otherBag.add("grape");

        // Prints contents
        // myBag.printContents();

        // Prints size
        myBag.printSize();
        otherBag.printSize();

        // Merges bags
        myBag.merge(otherBag);

        // Prints new contents
        myBag.printContents();

        // Gets distinct bag
        Bag<String> distinctBag = myBag.distinct();

        // Prints contents and size of distinct bag
        System.out.println("Distinct Bag:");
        distinctBag.printContents();
        distinctBag.printSize(); // Output will show size with distinct elements

        // Checks for an orange and apple 
        // System.out.println("\nDoes the bag contain 'orange'? " + myBag.contains("orange"));
        // System.out.println("\nDoes the bag contain 'apple'? " + myBag.contains("apple"));

        // Gets count
        // System.out.println("\nGetting counts for multiple items:");
        // myBag.getCount("apple").getCount("orange");

        // Removes an orange
        // System.out.println("\nRemoving an 'orange'...");
        // myBag.remove("orange");

	    // Prints again
        // myBag.printContents();

        // Prints size again
        // myBag.printSize();

        // Checks again to make sure orange was removed
        // System.out.println("\nDoes the bag contain 'orange'? " + myBag.contains("orange"));

        // Gets count for orange
        // System.out.println("\nGetting count for orange:");
        // myBag.getCount("orange");


    }
}
