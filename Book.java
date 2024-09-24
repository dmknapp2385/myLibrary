
import java.util.Comparator;

/*
 * class Book: represents a book object with a title and author
 * Authors: Elle Knapp(dmknapp2385) and Eman Ayaz(emanayaz)
 * 
 * Encapsulation is achieved in the immutability of the object and scope of the
 * instance variables. All fields are private and can only be accessed via the
 * class getters. Additionally, field values are strings which are immuntable, 
 * this makes the class itself immutable as once a book object is craeted, none
 * of the internal data can be altered. 
 */
public final class Book {

    String author;
    String title;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    //getters
    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }


    /*
     * Comparator class that returns a method to sort Book alphabetically by
     * title. This is not case sensitive. 
     */
    public static class CompareByTitle implements Comparator<Book> {

        public int compare(Book bOne, Book bTwo) {
            return bOne.title.compareToIgnoreCase(bTwo.title);
        }
    }

    /*
     * Comparator class that returns a method to sort Book alphabetically by
     * author. This is not case sensitive
     */
    public static class CompareByAuthor implements Comparator<Book> {

        public int compare(Book bOne, Book bTwo) {
            return bOne.author.compareToIgnoreCase(bTwo.author);
        }
    }


    /*
     * Compares two book objects to determin if they are the same book. Title
     * is case sensitive but author is not. 
     */
    public boolean equals(Book other) {
        return this.title.compareTo(other.title) == 0
                && this.author.compareToIgnoreCase(other.author) == 0;
    }
}
