import java.util.ArrayList;
import java.util.Comparator;

class Student {
    int rollno;

    Student(int rollno) {
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return "" + this.rollno;
    }
}

class RollNoComparator implements Comparator<Student> {
    
    @Override
    public int compare(Student s1, Student s2) {
        return s1.rollno - s2.rollno;
    }
}

public class StudentSortTest {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        
        students.add(new Student(105));
        students.add(new Student(586));
        students.add(new Student(74));
        students.add(new Student(2));
        students.add(new Student(84));
        students.add(new Student(1965));
        students.add(new Student(74));
        students.add(new Student(30));
        students.add(new Student(76));
        students.add(new Student(19));

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

        int mid = list.size() / 2;
        ArrayList<Student> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(list, left, right, comparator);
    }

    private static void merge(ArrayList<Student> list, ArrayList<Student> left, ArrayList<Student> right, Comparator<Student> comparator) {
        int i = 0, j = 0, k = 0;

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
