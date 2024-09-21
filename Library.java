
import java.util.ArrayList;

public class Library {

    /*post- returns a list of Book objects or the empty list */
    public ArrayList<Book> search(String searchParam, String toSearch) {
        return new ArrayList<Book>();

    }

    public ArrayList<Book> search(int rating) {
        return new ArrayList<Book>();

    }

    public void addBook(String title, String author) {

    }

    public ArrayList<Book> getBooks(int sortMethod) {
        return new ArrayList<Book>();
    }

    public Book suggestRead() {
        return new Book("test", "test");
    }

    public void setToRead(String title, String author) {

    }

    public void rate(String title, String author, int rating){
        
    }

    /*
     * throws NoSuchElementException
     */
    public boolean checkIfBookExists(String title, String author) {
        return false;
    }
}
