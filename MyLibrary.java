
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

class MyLibrary {

    static Library library = new Library();
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to your library. Press 1 to exit anytime.");

        while (true) {
            System.out.println("What would you like to do? You can search,"
                    + " addBook, setToRead, rate, getBooks, suggestRead, or addBooks.");
            String input = keyboard.nextLine();
            checkExit(input);
            input = input.toLowerCase().trim();
            if (input.equals("search")) {
                ArrayList<Book> books = searchBook();
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

    // method checks if input string is 1 and exits program if true
    private static void checkExit(String in) {
        if (in.equals("1")) {
            System.out.println("Goodbye!");
            keyboard.close();
            System.exit(1);
        }
    }

    // method gets user input for search type and name
    // calls library search method
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

    // method gets user input for title and author of book and 
    // adds to the library
    private static void addBook() {
        System.out.println("What is the name of the book you woud like to add? ");
        String title = keyboard.nextLine().trim();
        checkExit(title);
        System.out.println("What is the name of the author?");
        String author = keyboard.nextLine().trim();
        checkExit(author);
        library.addBook(title, author);
    }

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
                    System.out.println("What rating would you like to give this book, enter a number"
                            + "between 1 and 5");
                    rating = Integer.parseInt(keyboard.nextLine());
                    if (rating < 1 || rating > 6) {
                        System.out.println("Sorry this is not a valid rating.");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Sorry this is not a valid rating.");
                }
            }
            book.setToRead();
        } catch (NoSuchElementException e) {

        }
    }

    private static void getBooks() {

    }

    private static void suggestRead() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void addBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
