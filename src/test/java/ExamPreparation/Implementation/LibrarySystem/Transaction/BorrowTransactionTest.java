package ExamPreparation.Implementation.LibrarySystem.Transaction;

import ExamPreparation.Implementation.LibrarySystem.Book.Book;
import ExamPreparation.Implementation.LibrarySystem.Book.Status;
import ExamPreparation.Implementation.LibrarySystem.Library;
import ExamPreparation.Implementation.LibrarySystem.People.Librarian;
import ExamPreparation.Implementation.LibrarySystem.People.Member;
import junit.framework.TestCase;

import java.time.LocalDate;

public class BorrowTransactionTest extends TestCase {

    public void testCalculateLateFee() {
        Library library = new Library();
        Member member = new Member("456", "Ashley");
        Librarian librarian = new Librarian("001", "Nick");
        Book book1 = new Book("Goldfisch 1", "Nana Yaa", 2023, "4303250687612");
        Book book2 = new Book("Goldfisch 2", "Nana Yaa", 2023, "4303250687621");
        Book book3 = new Book("Goldfisch 3", "Nana Yaa", 2023, "4303250687612");
        Book book4 = new Book("Goldfisch 4", "Nana Yaa", 2023, "4303250687621");

        library.addLibrarian(librarian);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.registerMember(member);

        BorrowTransaction transaction = new BorrowTransaction(book1, LocalDate.of(2024, 9, 28), 14);
        try {
            library.borrowBook(member, book1);
        } catch (TooManyBooksException e) {
            throw new RuntimeException(e);
        }
        System.out.println(transaction.calculateLateFee());
        assertEquals(8.5, transaction.calculateLateFee());
    }

    public void testReturnBook() {
        Library library = new Library();
        Member member = new Member("456", "Ashley");
        Librarian librarian = new Librarian("001", "Nick");
        Book book1 = new Book("Goldfisch 1", "Nana Yaa", 2023, "4303250687612");
        Book book2 = new Book("Goldfisch 2", "Nana Yaa", 2023, "4303250687621");
        Book book3 = new Book("Goldfisch 3", "Nana Yaa", 2023, "4303250687612");
        Book book4 = new Book("Goldfisch 4", "Nana Yaa", 2023, "4303250687621");

        library.addLibrarian(librarian);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.registerMember(member);

        BorrowTransaction transaction = new BorrowTransaction(book1, LocalDate.of(2024, 10, 1), 14);
        try {
            library.borrowBook(member, book1);
        } catch (TooManyBooksException e) {
            throw new RuntimeException(e);
        }

        library.returnBook(transaction);
        assertTrue(transaction.isReturned());
    }
}