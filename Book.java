
import java.util.Comparator;


public class Book {

    boolean read;
    String author;
    String title;
    int rating;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void setToRead() {
        if (!read) {
            this.read = true;
        }
    }

    /*
     * @pre Rating is an integer between 1 and 5
     * 
     */
    public void rate(int rating) {
        this.rating = rating;
    }

    static class compareByTitle implements Comparator<Book>{
        public int compare(Book bOne, Book bTwo){
            return bOne.title.compareToIgnoreCase(bTwo.title);
        }
    }

    static class compareByAuthor implements Comparator<Book>{
        public int compare(Book bOne, Book bTwo){
            return bOne.author.compareToIgnoreCase(bTwo.author);
        }
    }
}
