package copy;

import java.util.HashMap;
import java.util.Objects;

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
    /*
        Author author = new Author("Togay Murod");
        Book a = new Book("Bobom Qolgan Dalalar", author);
        Book b = (Book) a.clone(); //  deep copy
        System.out.println(a);
        System.out.println(b);
        a.getAuthor().setName("Otabek");
        System.out.println(a);
        System.out.println(b);*/
        HashMap<String, Integer> subjectAndMark = new HashMap<>() {{
            put("math", 3);
            put("english", 4);
            put("history", 2);
        }};

        Student student = new Student("Uktam Sodiqov", subjectAndMark);


        Student clonedStudent = (Student) student.clone();

        subjectAndMark.put("math", 5);

        System.out.println("student = " + student);
        System.out.println("clonedStudent = " + clonedStudent);

    }
}

class Book implements Cloneable {
    private String title;
    private Author author;


    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book clone = (Book) super.clone();
        clone.setAuthor((Author) this.author.clone());
        return clone;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class Author implements Cloneable {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student implements Cloneable {
    private String fullName;
    private HashMap<String, Integer> subjectAndMark = new HashMap<>();

    public Student(String fullName, HashMap<String, Integer> subjectAndMark) {
        this.fullName = fullName;
        this.subjectAndMark = subjectAndMark;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student clone = (Student) super.clone();
        HashMap<String, Integer> s = new HashMap<>();
        this.subjectAndMark.forEach((k, v) -> s.put(k, v));
        clone.setSubjectAndMark(s);
        return clone;
    }


    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", subjectAndMark=" + subjectAndMark +
                '}';
    }

    public void setSubjectAndMark(HashMap<String, Integer> subjectAndMark) {
        this.subjectAndMark = subjectAndMark;
    }

    public HashMap<String, Integer> getSubjectAndMark() {
        return subjectAndMark;
    }

    public String getFullName() {
        return fullName;
    }
}