import java.util.ArrayList;
import java.util.Comparator;

class Student {
    int rollno;
    String name;
    String address;
    
    // Student object with constructor & toString for easy printing

    Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.rollno + ". " + this.name + ", " + this.address;
    }
}

class RollNoComparator implements Comparator<Student> {
    
    // Compares two Student objects based on rollno in ascending order
    
    @Override
    public int compare(Student s1, Student s2) {
        return s1.rollno - s2.rollno;
    }
}

public class studentSorter {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        
        // Creates ArrayList full of Student objects, all defined with rollno, name, and address and prints
        
        students.add(new Student(10, "Jim", "179 Preswick St"));
        students.add(new Student(5, "Jamie", "1337 Jorgen St"));
        students.add(new Student(7, "Jessica", "870 Smorgasbord Ln"));
        students.add(new Student(2, "James", "111 One St"));
        students.add(new Student(8, "Jeffery", "222 Two St"));
        students.add(new Student(1, "Jacob", "265 Street St"));
        students.add(new Student(4, "Jesse", "290 Road Rd"));
        students.add(new Student(3, "John", "505 Chicken Rd"));
        students.add(new Student(6, "Jonathan", "666 Happy St"));
        students.add(new Student(9, "Jack", "404 Unknown St"));

        mergeSort(students, new RollNoComparator());

        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void mergeSort(ArrayList<Student> list, Comparator<Student> comparator) {
        if (list.size() <= 1) {
            return;
        }

        // Recursively divides ArrayList into two halves, 'left' and 'right', until reaching the base case

        int mid = list.size() / 2;
        ArrayList<Student> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(list, left, right, comparator);
    }

    private static void merge(ArrayList<Student> list, ArrayList<Student> left, ArrayList<Student> right, Comparator<Student> comparator) {
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
}
