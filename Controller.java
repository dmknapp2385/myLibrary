
import java.util.Scanner;
import java.util.ArrayList;

class Controller {

    private Library library;
    private Scanner keyboard;

    public Controller(Library lib, Scanner keyboard) {
        this.library = lib;
        this.keyboard = keyboard;
    }

    /*
     * method checks if input string is 1 and exits program if true
     */
    public void checkExit(String in) {
        if (in.equals("0")) {
            System.out.println("Goodbye!");
            keyboard.close();
            System.exit(1);
        }
    }

    public ArrayList<Book> search(String searchP, String toSearch) {
        if (searchP.equals("title")) {
            return library.searchByTitle(toSearch);
        }
        return library.searchByAuthor(toSearch);
    }

    public ArrayList<Book> search(int rating) {
        return library.searchByRating(rating);

    }

    public void addBook(String title, String author) throws IllegalArgumentException {
        if (library.contains(title, author)) {
            throw new IllegalArgumentException("This book already exists");
        }
        if (title.equals("") || author.equals("")) {
            throw new IllegalArgumentException("Must have both title and author");
        }
        library.addBook(title, author);

    }

    public void setToRead(String title, String author) throws IllegalArgumentException{
        if (!library.contains(title, author)) {
            throw new IllegalArgumentException("Sorry no such book found");
        }
        library.getBook(title, author).setToRead();
    }

    public void rate(String title, String author, int rating) {
        if (!library.contains(title, author)) {
            throw new IllegalArgumentException("Sorry no such book found");
        }
        library.getBook(title, author).rate(rating);
    }

}
