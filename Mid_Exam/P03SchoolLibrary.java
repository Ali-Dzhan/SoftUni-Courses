package Mid_Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String shelf = scanner.nextLine().substring(0); // Remove the initial "&"
        List<String> books = new ArrayList<>();
        String[] initialBooks = shelf.split("&");

        for (String book : initialBooks) {
            books.add(book);
        }

        String input;
        while (!(input = scanner.nextLine()).equals("Done")) {
            String[] tokens = input.split(" \\| ");

            switch (tokens[0]) {
                case "Add Book":
                    String bookName = tokens[1];
                    if (!books.contains(bookName)) {
                        books.add(0, bookName);
                    }
                    break;
                case "Take Book":
                    String bookToRemove = tokens[1];
                    if (books.contains(bookToRemove)) {
                        books.remove(bookToRemove);
                    }
                    break;
                case "Swap Books":
                    String book1 = tokens[1];
                    String book2 = tokens[2];
                    if (books.contains(book1) && books.contains(book2)) {
                        int index1 = books.indexOf(book1);
                        int index2 = books.indexOf(book2);
                        books.set(index1, book2);
                        books.set(index2, book1);
                    }
                    break;
                case "Insert Book":
                    String bookToInsert = tokens[1];
                    if (!books.contains(bookToInsert)) {
                        books.add(bookToInsert);
                    }
                    break;
                case "Check Book":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < books.size()) {
                        System.out.println(books.get(index));
                    }
                    break;
            }
        }

        System.out.println(String.join(", ", books));
    }
}