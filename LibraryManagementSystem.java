// LibraryManagementSystem.java
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Create some initial books and users
        Book book1 = new Book("Java Basics", "John Doe", "1234");
        Book book2 = new Book("Advanced Java", "Jane Smith", "5678");
        Book book3 = new Book("Data Structures", "Mark Lee", "91011");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        User user1 = new User("Alice", "U001");
        User user2 = new User("Bob", "U002");

        // Register users in the library
        library.addUser(user1);
        library.addUser(user2);

        // Menu for the user to interact with
        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. List Books");
            System.out.println("2. List Users");
            System.out.println("3. Add Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (option) {
                case 1:
                    library.listBooks();
                    break;

                case 2:
                    library.listUsers();
                    break;

                case 3:
                    // Add a new book to the library
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    Book newBook = new Book(title, author, isbn);
                    library.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;

                case 4:
                    // Issue a book to a user
                    System.out.print("Enter user ID to issue book: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter ISBN of the book to issue: ");
                    String issueIsbn = scanner.nextLine();
                    library.issueBook(userId, issueIsbn);
                    break;

                case 5:
                    // Return a book
                    System.out.print("Enter user ID to return book: ");
                    String returnUserId = scanner.nextLine();
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnUserId, returnIsbn);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
