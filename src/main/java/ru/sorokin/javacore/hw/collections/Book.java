package ru.sorokin.javacore.hw.collections;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int year;
    private final Long bookId;

    public Book(String title, String author, int year, long bookId) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public long getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", bookId=" + bookId +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, bookId);
    }
}