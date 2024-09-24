
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Library {

    private ArrayList<Book> books;
    private HashMap<Integer, LinkedList<Book>> ratings;
    private ArrayList<Book> read;
    private ArrayList<Book> unread;

    public Library() {
        this.books = new ArrayList<Book>();
        this.ratings = new HashMap<Integer,LinkedList<Book>();
        //initialize empty lists for hash map
        for(int i = 0; i < 6; i++){
            ratings.put(i,new LinkedList<Book>());
        }
        this.read = new ArrayList<Book>();
        this.unread = new ArrayList<Book>();
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

    public void setToRead(String title, String author) {

    }

    /*
     * @pre rating is an integer value between 1 and 5
     * @post book with title and author will be moved to appropriate rating
     */
    public void rate(String title, String author, int rating) {

    }

    /*
     * @post returned book will be a random selection from unread books
     */
    public Book suggestRead() {
        return new Book("", "");
    }

    /*
     * Add book to list of books, default is to add to rating of 0 and unread
     */
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

    /*
     * Returns copy of books sorted in alphabetical order by title
     */
    public ArrayList<Book> sortTitle() {
        ArrayList<Book> copy = new ArrayList<>(books);
        Collections.sort(copy, new Book.CompareByTitle());
        return copy;

    }

    /*
     * Returns copy of books sorted in alphabetical order by author
     */
    public ArrayList<Book> sortAuthor() {
        ArrayList<Book> copy = new ArrayList<>(books);
        Collections.sort(copy, new Book.CompareByAuthor());
        return copy;
    }

    /*
     * Returns read books
     */
    public ArrayList<Book> sortRead() {
        return new ArrayList<Book>(read);
    }

    /*
     * Returns unread books
     */
    public ArrayList<Book> sortUnread() {
        return new ArrayList<Book>(unread);
    }

}
