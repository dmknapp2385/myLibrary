
import java.util.ArrayList;
import java.util.Collections;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    /*post- returns a list of Book objects or the empty list */
    public ArrayList<Book> searchByTitle(String title) {
        return new ArrayList<Book>();

    }

    public ArrayList<Book> searchByAuthor(String title) {
        return new ArrayList<Book>();

    }

    public ArrayList<Book> searchByRating(int rating) {
        return new ArrayList<Book>();

    }

    //get random unread book
    public Book suggestRead() {
        return new Book("", "");
    }

    //add a book
    public void addBook(String title, String author) {

    }

    /*
     * check if book in books
     */
    public boolean contains(String title, String author) {
        Book newBook = new Book(title, author);
        for (Book book : books) {
            if (book.equals(newBook)) {
                return true;
            }

        }
        return false;
    }

    //retuns a singular book to be changed
    public Book getBook(String title, String author) {
        return new Book(title, author);
    }

    /*
     * Returns copy of list sorted in alphabetical order by title
     */
    public ArrayList<Book> sortTitle() {
        ArrayList<Book> copy = new ArrayList<>(books);
        Collections.sort(copy, new Book.CompareByTitle());
        return copy;

    }

    /*
     * Returns copy of list sorted in alphabetical order by author
     */
    public ArrayList<Book> sortAuthor() {
        ArrayList<Book> copy = new ArrayList<>(books);
        Collections.sort(copy, new Book.CompareByAuthor());
        return copy;
    }

    /*
     * Returns list containing read books
     */
    public ArrayList<Book> sortRead() {
        ArrayList<Book> copy = new ArrayList<>();
        for (Book book : books) {
            if (book.read) {
                copy.add(book);
            }
        }
        return copy;
    }

    /*
     * Returns a list containing unread books
     */
    public ArrayList<Book> sortUnread() {
        ArrayList<Book> copy = new ArrayList<>();
        for (Book book : books) {
            if (!book.read) {
                copy.add(book);
            }
        }
        return copy;
    }

}
