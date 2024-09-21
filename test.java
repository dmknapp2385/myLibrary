
import java.util.ArrayList;
import java.util.Scanner;

class test {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        Scanner keyboard = new Scanner(System.in);

        System.out.println(ints.size());
        System.out.println("What rating would you like to give this book");
        int next = keyboard.nextInt();
        System.out.print(next);
    }
}