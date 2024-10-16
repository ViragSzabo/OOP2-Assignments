package ExamPreparation.Implementation.LibrarySystem;

import ExamPreparation.Implementation.LibrarySystem.Book.Book;
import ExamPreparation.Implementation.LibrarySystem.Transaction.TooManyBooksException;
import junit.framework.TestCase;

public class LibraryTest extends TestCase {
    Library library = new Library();
    private Book book1 = new Book("Goldfisch 1", "Nana Yaa", 2023, "4303250687612");
    private Book book2 = new Book("Goldfisch 2", "Nana Yaa", 2023, "4303250687621");
    private Book book3 = new Book("Goldfisch 3", "Nana Yaa", 2023, "4303250687612");
    private Book book4 = new Book("Goldfisch 4", "Nana Yaa", 2023, "4303250687621");

    public void testBorrowBook() {
        library.addBook(book1);
        library.addBook(book2);
        try {
            library.borrowBook(book1);
            library.borrowBook(book2);
            library.borrowBook(book3);
            library.borrowBook(book4);
            assertEquals(4, library.getBorrowedBooks().size());
            assertEquals(0, library.getAvailableBooks().size());
        } catch (TooManyBooksException e) {
            throw new RuntimeException(e);
        }
    }

    public void testReturnBook() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        try {
            library.borrowBook(book1);
            library.borrowBook(book2);
            library.borrowBook(book3);
            library.borrowBook(book4);
            library.returnBook(book1);
            library.returnBook(book2);
            assertEquals(0, library.getBorrowedBooks().size());
            assertEquals(2, library.getAvailableBooks().size());
        } catch (TooManyBooksException e) {
            throw new RuntimeException(e);
        }
    }
}