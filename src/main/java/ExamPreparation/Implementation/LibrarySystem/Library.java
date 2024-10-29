package ExamPreparation.Implementation.LibrarySystem;

import ExamPreparation.Implementation.LibrarySystem.Book.Book;
import ExamPreparation.Implementation.LibrarySystem.Book.Status;
import ExamPreparation.Implementation.LibrarySystem.People.Librarian;
import ExamPreparation.Implementation.LibrarySystem.People.Member;
import ExamPreparation.Implementation.LibrarySystem.Transaction.BorrowTransaction;
import ExamPreparation.Implementation.LibrarySystem.Transaction.TooManyBooksException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;
    private final List<Member> members;
    private final List<Librarian> librarians;
    private final List<BorrowTransaction> transactions;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.librarians = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Librarian> getLibrarian() {
        return librarians;
    }

    public List<Book> getAvailableBooks() {
        return books;
    }

    public void registerMember(Member member) {
        if(!members.contains(member)) {
            this.members.add(member);
        }
    }

    public void addLibrarian(Librarian librarian) {
        if(!librarians.contains(librarian)) {
            this.librarians.add(librarian);
        }
    }

    public void addBook(Book book) {
        if(!books.contains(book)) {
            this.books.add(book);
        }
    }

    public void removeMember(Member member) {
        if(members.contains(member)) {
            this.members.remove(member);
        }
    }

    public void removeLibrarian(Librarian librarian) {
        if(librarians.contains(librarian)) {
            this.librarians.remove(librarian);
        }
    }

    public List<BorrowTransaction> getTransactions() {
        return transactions;
    }

    public void borrowBook(Member member, Book book) throws TooManyBooksException {
        if (book.getStatus() == Status.AVAILABLE) {
            member.borrow(book);
            transactions.add(new BorrowTransaction(book, LocalDate.now(), 14));
        }
    }

    public void returnBook(BorrowTransaction transaction) {
        transaction.returnBook();
    }

    public double calculateOverdueFees(Member member) {
        return transactions.stream()
                .filter(transaction -> transaction.calculateLateFee() > 0)
                .mapToDouble(BorrowTransaction::calculateLateFee)
                .sum();
    }
}