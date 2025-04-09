import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", new BigDecimal("10.99"), "Scribner", LocalDate.of(1925, 4, 10));
        Book book2 = new Book("1984", "George Orwell", new BigDecimal("8.99"), "Secker & Warburg", LocalDate.of(1949, 6, 8));
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", new BigDecimal("12.99"), "J.B. Lippincott & Co.", LocalDate.of(1960, 7, 11));
        Book book4 = new Book("Moby-Dick", "Herman Melville", new BigDecimal("15.99"), "Richard Bentley", LocalDate.of(1851, 10, 18));
        Book book5 = new Book("1984", "George Orwell", new BigDecimal("8.99"), "Secker & Warburg", LocalDate.of(1949, 6, 8));

        System.out.println("Adding book1: " + store.add(book1));
        System.out.println("Adding book2: " + store.add(book2));
        System.out.println("Adding book3: " + store.add(book3));
        System.out.println("Adding book4: " + store.add(book4));
        System.out.println("Adding book5: " + store.add(book5));

        List<Book> orwellBooks = store.getAllBooksByAuthor("George Orwell");
        System.out.println("\nBooks by George Orwell: ");
        for(Book book : orwellBooks) {
            System.out.println(book.getTitle());
        }

        List<Book> booksAfter1950 = store.getAllBooksPublishedAfter(LocalDate.of(1950, 1, 1));
        System.out.println("\nBooks published after 1950: ");
        for(Book book : booksAfter1950) {
            System.out.println(book.getTitle());
        }

        List<Book> booksBetween1900and2000 = store.getAllBooksBetween(LocalDate.of(1900, 1, 1), LocalDate.of(2000, 12, 31));
        System.out.println("\nBooks between 1900 and 2000: ");
        for(Book book : booksBetween1900and2000) {
            System.out.println(book.getTitle());
        }

        Map<String, List<Book>> groupedByAuthor = store.getAllBooksGroupByAuthor();
        System.out.println("\nBooks grouped by author: ");
        for(String author : groupedByAuthor.keySet()) {
            System.out.println("Author: " + author);
            for(Book book : groupedByAuthor.get(author)) {
                System.out.println(" " + book.getTitle());
            }
        }

        Map<String, List<Book>> groupedByPublisher = store.getAllBooksGroupByPublisher();
        System.out.println("\nBooks grouped by publisher: ");
        for(String publisher : groupedByPublisher.keySet()) {
            System.out.println("Publisher: " + publisher);
            for(Book book : groupedByPublisher.get(publisher)) {
                System.out.println(" " + book.getTitle());
            }
        }

        store.clear();
        System.out.println("\nStore cleared. Books count: " + store.getAllBooksByAuthor("F. Scott Fitzgerald").size());
    }
}