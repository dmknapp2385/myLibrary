
import java.util.ArrayList;

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

    public void addBook(String title, String author) {
        // throw illegalargument exception with string constructor
        // "this book already exists" or "cannot have a blank author/title"

    }

    public ArrayList<Book> getBooks(int sortMethod) {
        return new ArrayList<Book>();
    }

    public Book suggestRead() {
        return new Book("test", "test");
    }

    public void setToRead(String title, String author) {
        //throw no such element exception if does not exits

    }

    public void rate(String title, String author, int rating) {
        // check if book exits and throw noSuchElement Exception
    }

    /*
     * throws NoSuchElementException
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

    public Book getBook(String title, String Author) {
        return new Book("", "");
    }

}
