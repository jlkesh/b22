package formatting;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

public class StringFormattingTest {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String fullName = "John";
        /*
        String age = "12";
        System.out.printf("Hello %2$-10s. Age %1$s%n", fullName, age);
        System.out.printf(Locale.CHINA, "ONE MLN %,d %n", 1_000_000);
        System.out.printf("%6.2f%n", 1D / 3);
        System.out.printf("%TicTakToe%n", "pdp");
        System.out.printf("%B%n", null);
        */
        /*Date date = new Date();
//        System.out.printf(Locale.forLanguageTag("UZ"),"%tA %<tB %<tl:%<tM:%<tS %<Tp %n", date);
//        System.out.printf(Locale.forLanguageTag("UZ"),"%tY/%<tm/%<td %<tI:%<tM:%<tS %<Tp %n", date);
        System.out.printf(Locale.forLanguageTag("UZ"), "%tR %n", date);
        String message = String.format(Locale.forLanguageTag("UZ"), "%tT %<Tp %n", date);
        System.out.printf(message);
        System.out.printf(Locale.forLanguageTag("UZ"), "%tr %n", date);
        System.out.printf(Locale.forLanguageTag("UZ"), "%tc %n", date);
        System.out.println(date);
        String formatted = "%tT %<Tp %n".formatted(date); // since jdk 15
        System.out.println("formatted = " + formatted);
        String message2 = MessageFormat.format("My name {1}, My Age {0}",
                "John", 123);
        System.out.println("message2 = " + message2);*/
        Book book = new Book("1", "Otamdan Qolgan Dalalar", "Togay Murod");
        System.out.printf("%60s", book);
        scanner.close();

    }
}


class Book implements Formattable {
    private final String id;
    private final String title;
    private final String author;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        Appendable out = formatter.out();
        try {
            String formatted = "[%s, %s, %s]".formatted(id, title, author);
            if (formatted.length() < width) {
                formatted = "*".repeat(width - formatted.length()) + formatted;
            }
            out.append(formatted);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
