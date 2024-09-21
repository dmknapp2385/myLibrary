
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

class MyLibrary {

    static Library library = new Library();
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        boolean end = false;
        System.out.println("Welcome to your library. Press 1 to exit anytime.");

        while (!end) {
            System.out.println("What would you like to do? You can search,"
                    + " addBook, setToRead, rate, getBooks, suggestRead, or addBooks.");
            String input = keyboard.nextLine();
            checkExit(input);

            input = input.toLowerCase().trim();
            if (input.equals("search")) {
                ArrayList<Book> book = searchBook();
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
        keyboard.close();
    }

    private static void checkExit(String in) {
        if (in.equals("1")) {
            System.out.println("Goodbye!");
            System.exit(1);
        }
    }

    private static ArrayList<Book> searchBook() {
        System.out.println("How would you like to search? By author, title"
                + " or rating?");
        String searchP = keyboard.nextLine().toLowerCase().trim();
        if (!searchP.equals("author")
                && !searchP.equals("title")
                && !searchP.equals("rating")) {
            System.out.println("Did not recognize that input");
            return new ArrayList<Book>();
        }
        System.out.println("What " + searchP + " would you like to search for?");
        String toSearch = keyboard.nextLine().toLowerCase().trim();
        return library.search(searchP, toSearch);
    }

    private static void addBook() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void setToRead() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void rate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void getBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void suggestRead() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void addBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
