// Library.java
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, User> users;

    public Library() {
        books = new HashMap<>();
        users = new HashMap<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    // Add a user to the library
    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    // Issue a book to a user
    public void issueBook(String userId, String isbn) {
        User user = users.get(userId);
        Book book = books.get(isbn);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isAvailable()) {
            user.borrowBook(book);
            book.setAvailable(false);
            System.out.println("Book issued successfully to " + user.getName());
        } else {
            System.out.println("Book is currently unavailable.");
        }
    }

    // Return a book to the library
    public void returnBook(String userId, String isbn) {
        User user = users.get(userId);
        Book book = books.get(isbn);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (user.getBorrowedBooks().contains(book)) {
            user.returnBook(book);
            book.setAvailable(true);
            System.out.println("Book returned successfully by " + user.getName());
        } else {
            System.out.println("This book was not borrowed by the user.");
        }
    }

    // List all books in the library
    public void listBooks() {
        System.out.println("Books available in the library:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    // List all registered users
    public void listUsers() {
        System.out.println("Users registered in the library:");
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
}
