package ExamPreparation.Implementation.LibrarySystem;

import ExamPreparation.Implementation.LibrarySystem.Book.Book;
import ExamPreparation.Implementation.LibrarySystem.Transaction.BorrowTransaction;
import ExamPreparation.Implementation.LibrarySystem.Transaction.OVERDUEEXCEPTION;
import ExamPreparation.Implementation.LibrarySystem.Transaction.TooManyBooksException;
import junit.framework.TestCase;

public class BorrowTransactionTest extends TestCase {
    private Library library = new Library();
    private BorrowTransaction transaction = new BorrowTransaction(library);
    private Book book1 = new Book("Goldfisch 1", "Nana Yaa", 2023, "4303250687612");
    private Book book2 = new Book("Goldfisch 2", "Nana Yaa", 2023, "4303250687621");
    private Book book3 = new Book("Goldfisch 3", "Nana Yaa", 2023, "4303250687612");
    private Book book4 = new Book("Goldfisch 4", "Nana Yaa", 2023, "4303250687621");

    public void testCheckAvailability() {
        library.addBook(book1);
        library.addBook(book2);
        try {
            library.borrowBook(book1);
        } catch (TooManyBooksException e) {
            throw new RuntimeException(e);
        }
        try {
            assertFalse(transaction.checkAvailability(book1));
            assertTrue(transaction.checkAvailability(book2));
        } catch (TooManyBooksException e) {
            throw new RuntimeException(e);
        }
    }

    public void testCheckDueDate() {
        library.addBook(book1);

        try {
            library.borrowBook(book1);
        } catch (TooManyBooksException e) {
            throw new RuntimeException(e);
        }

        try {
            assertEquals(0.0, transaction.checkDueDate(book1));
        } catch (OVERDUEEXCEPTION e) {
            throw new RuntimeException(e);
        }
    }
}