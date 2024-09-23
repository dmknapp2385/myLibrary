
import java.util.Comparator;

public class Book {

    boolean read;
    String author;
    String title;
    int rating;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.rating = 0;
        this.read = false;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getRead() {
        return this.read;
    }

    public void setToRead() {
        if (!read) {
            this.read = true;
        }
    }

    /*
     * @pre Rating is an integer between 1 and 5
     */
    public void rate(int rating) {
        this.rating = rating;
    }

    public static class CompareByTitle implements Comparator<Book> {

        public int compare(Book bOne, Book bTwo) {
            return bOne.title.compareToIgnoreCase(bTwo.title);
        }
    }

    public static class CompareByAuthor implements Comparator<Book> {

        public int compare(Book bOne, Book bTwo) {
            return bOne.author.compareToIgnoreCase(bTwo.author);
        }
    }

    public String toString() {
        return getTitle() + " : " + getAuthor();
    }

    public boolean equals(Book other) {
        return this.title.equals(other.title) && this.author.equals(other.author);
    }
}
