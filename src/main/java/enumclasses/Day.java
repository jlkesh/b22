package enumclasses;

public enum Day implements Cloneable {
    MONDAY("Dushanba"),
    FRIDAY("Juma"),
    SUNDAY("Yakshanba");

    private final String code;

    Day(String code) {
        this.code = code;
    }

    public static Day findByName(String name) {

        for (Day day : values()) {
            if (day.name().equalsIgnoreCase(name))
                return day;
        }
        return Day.FRIDAY;
    }
}

class Example {
    public static void main(String[] args) {

        Day friday = Day.FRIDAY;
        System.out.println(friday.name());
        System.out.println(friday.ordinal());

        for (Day day : Day.values()) {
            System.out.println(day.name() + "::" + day.ordinal());
        }
        Day sunday = Day.findByName("SUNDAY");
        System.out.println(sunday);
    }
}
