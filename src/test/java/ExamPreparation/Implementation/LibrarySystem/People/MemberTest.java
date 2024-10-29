package ExamPreparation.Implementation.LibrarySystem.People;

import ExamPreparation.Implementation.LibrarySystem.Book.Book;
import ExamPreparation.Implementation.LibrarySystem.Book.Status;
import ExamPreparation.Implementation.LibrarySystem.Library;
import ExamPreparation.Implementation.LibrarySystem.Transaction.TooManyBooksException;
import junit.framework.TestCase;

public class MemberTest extends TestCase {
    private Library library;
    private Member member;
    private Book book;

    @Override
    protected void setUp() {
        library = new Library();
        member = new Member("43", "John Doe");
        book = new Book("1984", "George Orwell", 1949, "123-456789");
        library.registerMember(member);
        library.addBook(book);
    }

    public void testBorrow() {
        try {
            // Member borrows the book
            member.borrow(book);
            assertEquals(1, member.getBorrowedBooks().size());
            assertEquals(Status.BORROWED, book.getStatus());
        } catch (TooManyBooksException e) {
            fail("Should not throw TooManyBooksException");
        }
    }

    public void testReserve() {
            book.setStatus(Status.BORROWED); // Assume the book is borrowed
            member.reserve(book);
            assertTrue(member.getReservedBooks().contains(book));
    }
}