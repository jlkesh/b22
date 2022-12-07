package recordclasses;

public class Main {
    public static void main(String[] args) {
        EmployeeDTO dto = new EmployeeDTO("1", "Abdullo", "22");
        EmployeeRecord record = new EmployeeRecord("-1", "Abdullo", "22");
        System.out.println("dto = " + dto);
        System.out.println("record = " + record);
        System.out.println(record.fullInfo());
        System.out.println(EmployeeRecord.field);
    }
}
