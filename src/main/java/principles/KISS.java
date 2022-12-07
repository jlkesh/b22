package principles;

public class KISS {

    public String withoutKISS(int day) {
        return switch (day) {
            case 1 -> "Dushanba";
            case 2 -> "Seshanba";
            default -> "Kun topilmadi";
        };
    }

    public String withKISS(int day) {
        if (day < 1 || day > 7)
            return "kun topilmadi";
        String[] days = {"Dushanba", "Seshanba"};
        return days[day - 1];
    }


    public static void main(String[] args) {

    }
}
