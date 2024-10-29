package ExamPreparation.Implementation.LibrarySystem;

import ExamPreparation.Implementation.LibrarySystem.Book.Book;
import ExamPreparation.Implementation.LibrarySystem.Book.Status;
import ExamPreparation.Implementation.LibrarySystem.People.Member;
import ExamPreparation.Implementation.LibrarySystem.Transaction.BorrowTransaction;
import ExamPreparation.Implementation.LibrarySystem.Transaction.TooManyBooksException;
import junit.framework.TestCase;

import java.time.LocalDate;

public class LibraryTest extends TestCase {
    private Library library;
    private Member member;
    private Book book;

    @Override
    protected void setUp() {
        library = new Library();
        member = new Member("43", "John Doe");
        book = new Book("1984", "George Orwell",1949, "123-456789");
        library.registerMember(member);
        library.addBook(book);
    }

    public void testRegisterMember() {
        assertTrue(library.getMembers().contains(member));
    }

    public void testBorrowBook() {
        try {
            library.borrowBook(member, book);
            assertEquals(Status.BORROWED, book.getStatus());
        } catch (TooManyBooksException e) {
            throw new RuntimeException(e);
        }
    }

    public void testReturnBook() {
        try {
            library.borrowBook(member, book);
            BorrowTransaction transaction = library.getTransactions().get(0);
            library.returnBook(transaction);
            assertEquals(Status.AVAILABLE, book.getStatus());
        } catch (TooManyBooksException e) {
            throw new RuntimeException(e);
        }
        assertEquals(Status.AVAILABLE, book.getStatus());
    }

    public void testCalculateOverdueFees() {
        try {
            library.borrowBook(member, book);
            BorrowTransaction transaction = library.getTransactions().get(0);
            transaction.setReturnDate(LocalDate.now().minusDays(5));  // Set overdue by 5 days
            assertEquals(2.5, library.calculateOverdueFees(member), 0.01);
        } catch (TooManyBooksException e) {
            fail("Exception should not be thrown.");
        }
    }
}