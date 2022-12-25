package collectionsframework.beforegenerics.compare;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MockDATA {

    public static List<Student> generateStudents(int count) {
        var faker = new Faker(Locale.forLanguageTag("ru"));
        var name = faker.name();
        var address = faker.address();
        var students = new ArrayList<Student>();
        var rand = new Random();
        for (int i = 0; i < count; i++) {
            students.add(new Student(name.firstName(), name.lastName(), rand.nextInt(18, 22), address.fullAddress()));
        }
        students.add(new Student("Alisher", "Akbarov", 18, "Qabrsanskiy"));
        students.add(new Student("Akbar", "Akbarov", 15, "Qabrsanskiy"));
        students.add(new Student("Akbar", "Akbarov", 11, "Qabrsanskiy 2/5"));
//        students.add(new Student("Akbarov", "Akbar", 15, "Qabrsanskiy"));
        return students;
    }

}
