package ExamPreparation.Implementation.LibrarySystem;

import ExamPreparation.Implementation.LibrarySystem.Book.Book;
import ExamPreparation.Implementation.LibrarySystem.People.Librarian;
import ExamPreparation.Implementation.LibrarySystem.People.Member;
import ExamPreparation.Implementation.LibrarySystem.Transaction.TooManyBooksException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<Book, LocalDateTime> borrowedBooks;
    private final List<Book> availableBooks;
    private final List<Member> members;
    private final List<Librarian> librarians;

    public Library() {
        this.borrowedBooks = new HashMap<>();
        this.availableBooks = new ArrayList<>();
        this.members = new ArrayList<>();
        this.librarians = new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Librarian> getLibrarian() {
        return librarians;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public Map<Book, LocalDateTime> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    public void addLibrarian(Librarian librarian) {
        this.librarians.add(librarian);
    }

    public void addBook(Book book) {
        this.availableBooks.add(book);
    }

    public void removeMember(Member member) {
        this.members.remove(member);
    }

    public void removeLibrarian(Librarian librarian) {
        this.librarians.remove(librarian);
    }

    public void borrowBook(Book book)  throws TooManyBooksException {
        for(Member member : members) {
            if(member.getBooks().size() < 3) {
                this.borrowedBooks.put(book, LocalDateTime.now());
                this.availableBooks.remove(book);
            } else {
                throw new TooManyBooksException("There are too many books out.");
            }
        }
    }

    public void returnBook(Book book) {
        this.availableBooks.add(book);
        this.borrowedBooks.remove(book);
    }
}