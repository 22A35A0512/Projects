
import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean borrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public boolean borrow() {
        if (borrowed) {
            return false;
        } else {
            borrowed = true;
            return true;
        }
    }

    public boolean returnBook() {
        if (!borrowed) {
            return false;
        } else {
            borrowed = false;
            return true;
        }
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}

class Member {
    private String name;
    private List<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean borrowBook(Book book) {
        if (book.borrow() && !borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(Book book) {
        if (book.returnBook() && borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            return true;
        } else {
            return false;
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        // Creating books
        Book book1 = new Book("Title 1", "Author 1", "ISBN 1");
        Book book2 = new Book("Title 2", "Author 2", "ISBN 2");
        Book book3 = new Book("Title 3", "Author 3", "ISBN 3");

        // Creating library
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Creating member
        Member member = new Member("John");

        // Borrowing and returning books
        member.borrowBook(book1);
        member.borrowBook(book2);

        member.returnBook(book1);

        // Getting available books
        List<Book> availableBooks = library.getAvailableBooks();
        System.out.println("Available Books:");
        for (Book book : availableBooks) {
            System.out.println(book.getTitle());
        }
    }
}
