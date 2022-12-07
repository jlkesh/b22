package recordclasses;

import java.io.Serializable;

public record EmployeeRecord(String id, String fullName, String age) implements Serializable {


    public final static String field = "direct init";

    public String fullInfo() {
        return "%s:%s:%s"
                .formatted(this.id, this.fullName, this.age);
    }

    /** // canonical constructor
     public EmployeeRecord(String id, String fullName, String age) {
     if (id.startsWith("-")) {
     throw new IllegalArgumentException("Id can not be negative");
     }
     this.id = id;
     this.fullName = fullName;
     this.age = age;
     } */

    /*public EmployeeRecord {
        if (id.startsWith("-")) {
            throw new IllegalArgumentException("id  can not be negative");
        }
    }*/
}
