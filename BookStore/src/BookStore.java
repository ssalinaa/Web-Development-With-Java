import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class BookStore implements Store {
    private final Map<String, Book> books;

    public BookStore() {
        this.books = new HashMap<>();
    }

    @Override
    public boolean add(Book book) {
        String key = generateKey(book);
        if(books.containsKey(key)) {
            return false;
        }
        books.put(key, book);
        return true;
    }

    @Override
    public void remove(Book book) {
        String key = generateKey(book);
        books.remove(key);
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        List<Book> filtered = new ArrayList<>();
        for(Book book : books.values()) {
            if(book.getAuthor() == author) {
                filtered.add(book);
            }
        }
        return filtered;
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        List<Book> filtered = new ArrayList<>();
        for(Book book : books.values()) {
            if(book.getPublishedYear().isAfter(from)) {
                filtered.add(book);
            }
        }
        return filtered;
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        List<Book> filtered = new ArrayList<>();
        for(Book book : books.values()) {
            if((book.getPublishedYear().isEqual(from) || book.getPublishedYear().isAfter(from))
                    && (book.getPublishedYear().isEqual(to) || book.getPublishedYear().isBefore(to))) {
                filtered.add(book);
            }
        }
        return filtered;
    }

    @Override
    public void clear() {
        books.clear();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        Map<String, List<Book>> groupedByAuthor = new HashMap<>();
        for(Book book : books.values()) {
            groupedByAuthor
                    .computeIfAbsent(book.getAuthor(), k -> new ArrayList<>())
                    .add(book);
        }
        return groupedByAuthor;
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        Map<String, List<Book>> groupedByPublisher = new HashMap<>();
        for(Book book : books.values()) {
            groupedByPublisher
                    .computeIfAbsent(book.getPublisher(), k -> new ArrayList<>())
                    .add(book);
        }
        return groupedByPublisher;
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        List<Book> filtered = new ArrayList<>();
        for(Book book : books.values()) {
            if(bookPredicate.test(book)) {
                filtered.add(book);
            }
        }
        return filtered;
    }

    private String generateKey(Book book) {
        return book.getAuthor() + "-" + book.getTitle() + "-" + book.getPublishedYear();
    }
}
