
import java.util.ArrayList;
import java.util.Scanner;

/* 
 * class Controller represents a controller between the MyLibrary view and the
 * Library model. 
 * 
 * Authors: Elle Knapp(dmknapp2385) and Eman Ayaz(emanayaz)
 * 
 * Encapsulation is maintained in this class as the view does not have direct 
 * access to the library field. All manipulations of the library object are done
 * through methods. Additionally, any list returned via these methods are copies
 * of the origina data stored in library. 
 */
public class Controller {

    private Library library = new Library();

   
    /*
     * Method returns a list of books based on title or author name
     * 
     * @pre the searchP is a string "title" or "author"
     * @post an ArrayList of Book objects is returned, or an emtpy list
     * 
     */
    public ArrayList<Book> search(String searchP, String toSearch) {
        if (searchP.equals("title")) {
            return library.searchByTitle(toSearch);
        }
        return library.searchByAuthor(toSearch);
    }

    /*
     * Method returns a list of books based on the input rating
     * 
     * @pre rating is an integer between 1 and 5
     * @post an ArrayList of Book objects is returned, or an emtpy list
     * 
     */
    public ArrayList<Book> search(int rating) {
        return library.searchByRating(rating);

    }

    /*
     * Method adds a new book to the library if the book does not already exist
     * 
     * @throws Illegal argument exception if title or author is empty or if 
     *  book already exists in the library
     */
    public void addBook(String title, String author) throws IllegalArgumentException {
        if (library.contains(title, author)) {
            throw new IllegalArgumentException("This book already exists.");
        }
        if (title.equals("") || author.equals("")) {
            throw new IllegalArgumentException("Must have both title and author.");
        }
        library.addBook(title, author);

    }

    /*
     * Method sets a book to read within the library
     * 
     * @throws IllegalArgumentException if book does not exist in the library
     * 
     */
    public void setToRead(String title, String author) throws IllegalArgumentException {
        if (!library.contains(title, author)) {
            throw new IllegalArgumentException("Sorry no such book found");
        }
        library.setToRead(title, author);
    }

    /*
     * Method either sets a rating or changes the rating of a book
     * 
     * @throws IllegalArgumentException if book does not exist in the library
     * @post method will override previous rating if book was already rated. 
     * 
     */
    public void rate(String title, String author, int rating) throws IllegalArgumentException {
        if (!library.contains(title, author)) {
            throw new IllegalArgumentException("Sorry no such book found");
        }
        library.rate(title, author, rating);
    }

    /*
     *
     * Method returns an ArrayList of book objects sorted in the specified way.
     * 
     * @pre sortMeth is an integer between 1 and 4. 
     * @post method returns an ArrayList of Book objects or the empty list if 
     *      none are found
     */
    public ArrayList<Book> getBooks(int sortMeth) {
        if (sortMeth == 1) {
            return library.sortTitle();
        }
        if (sortMeth == 2) {
            return library.sortAuthor();
        }
        if (sortMeth == 3) {
            return library.sortRead();
        }
        return library.sortUnread();
    }

    /*
     * Method returns a random book from the unread books in the library
     */
    public Book suggestRead() {
        return library.suggestRead();
    }

}
