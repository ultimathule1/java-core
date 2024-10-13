package ru.sorokin.javacore.hw.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LibraryService {
    private final Map<Long, User> users;
    private final Map<Long, Book> books;
    private final Map<Long, Long> takenBook;            //<id book, id user>
    private final Map<Long, Set<Long>> takenBooksByUser;

    public LibraryService(List<User> users, List<Book> books) {
        this.users = new HashMap<>();
        this.books = new HashMap<>();
        this.takenBook = new HashMap<>();
        this.takenBooksByUser = new HashMap<>();

        for (User user : users) {
            this.users.put(user.getUserId(), user);
        }

        for (Book book : books) {
            this.books.put(book.getBookId(), book);
        }
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public List<Book> getAllAvailableBooks() {
        List<Book> tempAvailableBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (!takenBook.containsKey(book.getBookId())) {
                tempAvailableBooks.add(book);
            }
        }
        return tempAvailableBooks;
    }

    public List<Book> getUserBooks(Long userId) {
        if (!users.containsKey(userId)) {
            throw new IllegalArgumentException("User not found");
        } else if (!takenBooksByUser.containsKey(userId)) {
            throw new IllegalArgumentException("User didn't take books");
        }
        List<Book> tempUserBooks = new ArrayList<>();
        Set<Long> temp = takenBooksByUser.get(userId);
        for (Long id : temp) {
            if (books.containsKey(id)) {
                tempUserBooks.add(books.get(id));
            }
        }

        return tempUserBooks;
    }

    public Book takeBook(Long userId, Long bookId) {
        if (!books.containsKey(bookId) || !users.containsKey(userId)) {
            throw new IllegalArgumentException("Book or User not found");
        } else if (takenBook.containsKey(bookId)) {
            throw new IllegalArgumentException("Book already taken");
        }

//        if (takenBooksByUser.containsKey(userId)) {
//            takenBooksByUser.get(userId).add(bookId);
//        } else {
//            takenBooksByUser.put(userId, new HashSet<>());
//            takenBooksByUser.get(userId).add(bookId);
//        }
        if (!takenBooksByUser.containsKey(userId)) {
            takenBooksByUser.put(userId, new HashSet<>());
        }
        takenBooksByUser.get(userId).add(bookId);
        takenBook.put(bookId, userId);

        return books.get(bookId);
    }

    public void returnBook(Long userId, Long bookId) {
        if (!books.containsKey(bookId) || !users.containsKey(userId)) {
            throw new IllegalArgumentException("Book or User not found");
        } else if (!takenBook.containsKey(bookId)) {
            throw new IllegalArgumentException("Nobody taken the book");
        } else if (!takenBook.containsValue(userId)) {
            throw new IllegalArgumentException("That user did not take the book");
        }

        takenBook.remove(bookId);
        takenBooksByUser.get(userId).remove(bookId);
    }

    @Override
    public String toString() {
        return "LibraryService{" +
                "users=" + users +
                ", books=" + books +
                ", booksByUser=" + takenBook +
                ", availableBooks=" + takenBooksByUser +
                '}';
    }
}
