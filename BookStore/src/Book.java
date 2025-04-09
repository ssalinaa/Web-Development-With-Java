import java.math.BigDecimal;
import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private BigDecimal price;
    private String publisher;
    private LocalDate publishedYear;

    public Book(String title, String author, BigDecimal price, String publisher, LocalDate publishedYear) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getPublishedYear() {
        return publishedYear;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return title.equals(book.title) && author.equals(book.author) && publishedYear.equals(book.publishedYear);
    }

    @Override
    public int hashCode() {
        return (title + author + publishedYear.toString()).hashCode();
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', price=" + price +
                ", publisher='" + publisher + "', publishedYear=" + publishedYear + '}';
    }
}
