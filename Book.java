
import java.util.Comparator;

public class Book {

    String author;
    String title;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
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


    public boolean equals(Book other) {
        return this.title.equals(other.title) && this.author.equals(other.author);
    }
}
