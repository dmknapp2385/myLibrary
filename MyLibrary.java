
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/*
 * Program: Large Assignment 2
 * Authors: Elle Knapp (dmknapp2385) and Eman Ayaz()
 * 
 */
class MyLibrary {

    static Library library = new Library();
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to your library. Press 1 to exit anytime.");

        //Get user input for library command
        while (true) {
            System.out.println("What would you like to do? You can search,"
                    + " addBook, setToRead, rate, getBooks, suggestRead, or addBooks.");
            String input = keyboard.nextLine();
            checkExit(input);
            input = input.toLowerCase().trim();
            if (input.equals("search")) {
                ArrayList<Book> books = searchBook();
                if (!books.isEmpty()) {
                    for (Book book : books) {
                        System.out.println(book.getTitle() + " : " + book.getAuthor());
                    }
                }
            } else if (input.equals("addBook")) {
                addBook();
            } else if (input.equals("setToRead")) {
                setToRead();
            } else if (input.equals("rate")) {
                rate();
            } else if (input.equals("getBooks")) {
                getBooks();
            } else if (input.equals("suggestRead")) {
                suggestRead();
            } else if (input.equals("addBooks")) {
                addBooks();
            } else {
                System.out.println("Did not regcognize the command. Please "
                        + "enter again");
            }

        }
    }

    /*
     * method checks if input string is 1 and exits program if true
     */
    private static void checkExit(String in) {
        if (in.equals("1")) {
            System.out.println("Goodbye!");
            keyboard.close();
            System.exit(1);
        }
    }

    /*
     * Method gets user input for search type and name and gets all books 
     * corresponding to those inputs
     */
    private static ArrayList<Book> searchBook() {
        System.out.println("How would you like to search? By author, title"
                + " or rating?");
        String searchP = keyboard.nextLine().toLowerCase().trim();
        checkExit(searchP);
        if (!searchP.equals("author")
                && !searchP.equals("title")
                && !searchP.equals("rating")) {
            System.out.println("Did not recognize that input");
            return new ArrayList<Book>();
        }
        System.out.println("What " + searchP + " would you like to search for?");
        String toSearch = keyboard.nextLine().toLowerCase().trim();
        checkExit(toSearch);
        try {
            return library.search(searchP, toSearch);
        } catch (NoSuchElementException e) {
            return new ArrayList<Book>();
        }
    }

    /*
     * Method gets user input for title and author of a book and adds it to the 
     * library if it does not already exist
     */
    private static void addBook() {
        System.out.println("What is the name of the book you woud like to add? ");
        String title = keyboard.nextLine().trim();
        checkExit(title);
        System.out.println("What is the name of the author?");
        String author = keyboard.nextLine().trim();
        checkExit(author);
        library.addBook(title, author);
    }

    /*
     * Method gets user input for title of a book and sets to read if found
     */
    private static void setToRead() {
        System.out.println("What is the name of the book you woud like to read?");
        String title = keyboard.nextLine().trim();
        checkExit(title);
        try {
            ArrayList<Book> books = library.search("title", title);
            Book book = books.get(0);
            book.setToRead();
        } catch (NoSuchElementException e) {
        }
    }

    /*
     * Method gets input for book and rating and changes book to specified 
     * rating if the book can be found. 
     */
    private static void rate() {
        System.out.println("What is the name of the book you woud like to rate?");
        String title = keyboard.nextLine().trim();
        checkExit(title);
        try {
            ArrayList<Book> books = library.search("title", title);
            Book book = books.get(0);
            Integer rating;
            while (true) {
                try {
                    System.out.println("What rating would you like to give this"
                            + " book, enter a number between 1 and 5");
                    String input = keyboard.nextLine().trim();
                    checkExit(input);
                    rating = Integer.parseInt(input);
                    if (rating < 1 || rating > 6) {
                        System.out.println("Sorry this is not a valid rating.");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Sorry this is not a valid rating.");
                }
            }
            book.rate(rating);
        } catch (NoSuchElementException e) {

        }
    }

    /*
     * Method retrieves all books from the library sorted in alphabetical order
     * by title, or author. Or returns read/unread books. User input determines 
     * how to sort
     */
    private static void getBooks() {

    }

    /*
     * Method returns a ranodm unread book from the library
     */
    private static void suggestRead() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*
     * Method adds multiple books to the library after reading them in from a
     * textfile. User input is the name of a file/path.
     * 
     * @pre- textfile must be in the format title;autor
     * @throws- FileNotFoundException if file not found at input path
     */
    private static void addBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
