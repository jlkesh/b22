package encapsulation;

public class Encapsulation {

    public static void main(String[] args) {
        Author author = new Author("Josh Long");
        Book book = new Book("Concurrency in Practise", "600");
        book.setAuthor(author);
        author.setName("ewferter");
        System.out.println(book);
        Author author2 = book.getAuthor();
        author2.setName("Adash");
        System.out.println(book);
    }

}

class Book {
    private String title;
    private String pageCount;
    private Author author;

    public Book() {
    }

    public Book(String title, String pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public Book(String title, String pageCount, Author author) {
        this.title = title;
        this.pageCount = pageCount;
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public void setAuthor(Author author) {
        try {
            this.author = (Author) author.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getPageCount() {
        return pageCount;
    }

    public Author getAuthor() {
        try {
            return (Author) author.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount='" + pageCount + '\'' +
                ", author=" + author +
                '}';
    }
}

class Author implements Cloneable{
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
