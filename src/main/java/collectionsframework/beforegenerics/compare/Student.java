package collectionsframework.beforegenerics.compare;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student/* implements Comparable<Student>*/ {
    private String firstName;
    private String lastName;
    private int age;
    private String address;

/*    @Override
    public int compareTo(Student student) {
        int i = lastName.compareTo(student.getLastName());
        if (i == 0) {
            i = firstName.compareTo(student.firstName);
        }
        return i;
    }*/

    @Override
    public String toString() {
        return "%s,  %s,  %s,  %s".formatted(
                lastName, firstName, age, address
        );
    }
}
