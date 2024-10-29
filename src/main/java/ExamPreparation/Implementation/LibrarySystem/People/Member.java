package ExamPreparation.Implementation.LibrarySystem.People;

import ExamPreparation.Implementation.LibrarySystem.Book.Book;
import ExamPreparation.Implementation.LibrarySystem.Book.Status;
import ExamPreparation.Implementation.LibrarySystem.Transaction.TooManyBooksException;

import java.util.ArrayList;
import java.util.List;

public class Member extends People {
    private List<Book> borrowedBooks;
    private List<Book> reservedBooks;

    public Member(String iD, String name) {
        super(iD, name);
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<Book> getReservedBooks() {
        return reservedBooks;
    }

    public void setReservedBooks(List<Book> reservedBooks) {
        this.reservedBooks = reservedBooks;
    }

    public void borrow(Book book) throws TooManyBooksException {
        if(borrowedBooks.size() >= 3) {
            throw new TooManyBooksException("Cannot borrow more than 3 Books");
        }
        borrowedBooks.add(book);
        book.setStatus(Status.BORROWED);
    }

    public void reserve(Book book) {
        if(book.getStatus() == Status.BORROWED) {
            reservedBooks.add(book);
        }
    }
}