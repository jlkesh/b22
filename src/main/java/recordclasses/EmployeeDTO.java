package recordclasses;

import java.util.Objects;

public class EmployeeDTO {
    private final String id;
    private final String fullName;
    private final String age;

    public EmployeeDTO(String id, String fullName, String age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return id.equals(that.id) && fullName.equals(that.fullName) && age.equals(that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, age);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
