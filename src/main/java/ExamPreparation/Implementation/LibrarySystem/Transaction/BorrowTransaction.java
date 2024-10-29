package ExamPreparation.Implementation.LibrarySystem.Transaction;

import ExamPreparation.Implementation.LibrarySystem.Book.Book;
import ExamPreparation.Implementation.LibrarySystem.Book.Status;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowTransaction {
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean returned;

    public BorrowTransaction(Book book, LocalDate borrowDate, int borrowDays) {
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = borrowDate.plusDays(borrowDays);
        this.returned = false;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double calculateLateFee() {
        if (!returned && LocalDate.now().isAfter(returnDate)) {
            int overdueDays = (int) ChronoUnit.DAYS.between(returnDate, LocalDate.now());
            return overdueDays * 0.5;
        }
        return 0;
    }

    public void returnBook() {
        book.setStatus(Status.AVAILABLE);
        this.returned = true;
    }
}