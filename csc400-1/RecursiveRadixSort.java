import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveRadixSort {

    public static void radixSort(int[] array) {
        // Finds maximum number of digits in the largest number
        int maxDigits = getMaxDigits(array);
        // Calls helper to start the recursive sort, starting at index 0
        radixSortHelper(array, 0, maxDigits);
    }

    private static void radixSortHelper(int[] array, int digitIndex, int maxDigits) {
        // Stops if base case is reached
        if (digitIndex >= maxDigits) {
            return;
        }

        // Creates buckets for digits 0-9
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distributes numbers into buckets based on the current digit
        for (int num : array) {
            int digit = getDigitAt(num, digitIndex);
            buckets.get(digit).add(num);
        }

        // Concatenates buckets into an array
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[index++] = num;
            }
        }

        // Calls itself, increasing index by 1
        radixSortHelper(array, digitIndex + 1, maxDigits);
    }

    // Finds digit at a specific position
    private static int getDigitAt(int number, int position) {
        return (number / (int) Math.pow(10, position)) % 10;
    }

    // Finds maximum number of digits in the array
    private static int getMaxDigits(int[] array) {
        int max = Arrays.stream(array).max().orElse(0);
        return String.valueOf(max).length();
    }

    // Main driver method! Creates initial array of given numbers
    public static void main(String[] args) {
        int[] array = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        System.out.println("Original array: " + Arrays.toString(array));
        radixSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

    // Math time!! yippee!!
    // Number of elements in the given array = n
    // Number of digits to represent each number = d
    // Number of possibilities for each digit = b (which is obviously 10, 0 thru 9)
    // Going through an array of one digit numbers would just be O(n+b)
    // Since we have numbers of multiple digits, however, n+b would be multiplied by the
    // number of digits it has to go through. So, in this case, the complexity would be:
    // O(d(n+b))
    // Since n=11, d=3, and b=10...
    // O(3(11+10))
    // O(63)
