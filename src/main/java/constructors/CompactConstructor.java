package constructors;

public class CompactConstructor {

}


record Book(String id, String title, String author) {

    /*public Book(String id, String title,String author){ // canonical
        this.id = id;
        this.title = title;
        this.author = author;
    }*/

    public Book { // compact constructor
    }
}
