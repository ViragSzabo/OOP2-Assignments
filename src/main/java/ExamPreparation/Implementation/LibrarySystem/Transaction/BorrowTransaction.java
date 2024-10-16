package ExamPreparation.Implementation.LibrarySystem.Transaction;

import ExamPreparation.Implementation.LibrarySystem.Book.Book;
import ExamPreparation.Implementation.LibrarySystem.Book.Status;
import ExamPreparation.Implementation.LibrarySystem.Library;

public class BorrowTransaction {
    private final Library library;
    private final double LATEFEE;
    private final int DUE_DAY;

    public BorrowTransaction(Library library) {
        this.library = library;
        this.LATEFEE = 1.0;
        this.DUE_DAY = 30;
    }

    public boolean checkAvailability(Book requestedBook) throws TooManyBooksException {
        for(Book book : library.getAvailableBooks()) {
            if(book.equals(requestedBook) && requestedBook.getStatus() == Status.AVAILABLE) {
                library.borrowBook(requestedBook);
                return requestedBook.getStatus() == Status.AVAILABLE;
            }
        }
        return false;
    }

    public double checkDueDate(Book requestedBook) throws OVERDUEEXCEPTION {
        double priceToPay = 0;
        int day = library.getBorrowedBooks().get(requestedBook).getDayOfMonth();
        if(library.getBorrowedBooks().containsKey(requestedBook)) {
            if(day > DUE_DAY) {
                priceToPay = (day - DUE_DAY) * LATEFEE;
                System.out.println("Current payment: " + priceToPay);
                throw new OVERDUEEXCEPTION("PLEASE RETURN THE BOOK! It's been past the due date!");
            } else {
                System.out.println(requestedBook + " has been out for " + day + " days.");
            }
        }
        return priceToPay;
    }
}