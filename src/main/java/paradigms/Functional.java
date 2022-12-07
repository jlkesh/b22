package paradigms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Functional {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(); // 10k

        // imperative
        int counter = 0;
        int limit = 10;
        List<Student> studentsAgeUnder18 = new ArrayList<>();
        for (Student student : students) {
            if (student.age < 18) {
                studentsAgeUnder18.add(student);
                counter++;
            }
            if (counter == limit)
                break;
        }

        // declorative
        Predicate<Student> studentPredicate = student -> student.age < 18;
        List<Student> studentsUnder182 = students
                .stream()
                .filter(studentPredicate)
                .limit(limit)
                .toList();



    }
}

class Student {
    int age;
}