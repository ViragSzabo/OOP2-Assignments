package ExamPreparation.Implementation.LibrarySystem.People;

import ExamPreparation.Implementation.LibrarySystem.Book.Book;

import java.util.ArrayList;
import java.util.List;

public abstract class People {
    private final String iD;
    private final String name;
    private final List<Book> books;

    public People(String iD, String name) {
        this.iD = iD;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getiD() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}