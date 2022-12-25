package collectionsframework.beforegenerics.compare;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class StudentTest {
    public static void main(String[] args) {
        var students = MockDATA.generateStudents(15);
        students.forEach(System.out::println);
        System.out.println("----------------");
        students.sort(Comparator.comparing(Student::getLastName)
                .thenComparing(Student::getFirstName)
                .thenComparing(Student::getAge)
        );
        students.forEach(System.out::println);
        var tr = new TreeSet<Student>(Comparator.comparing(Student::getFirstName));
    }
}
