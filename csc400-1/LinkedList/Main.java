import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        // Insert elements
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);

        // Display elements
        System.out.print("List after insertion: ");
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Delete an element
        linkedList.delete(2);

        // Display elements after deletion
        System.out.print("List after deletion of 2: ");
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
