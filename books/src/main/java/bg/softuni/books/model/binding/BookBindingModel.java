package bg.softuni.books.model.binding;

public class BookBindingModel {

    private String title;

    private AuthorBindingModel author;

    private String isbn;

    public BookBindingModel() {
    }

    public String getTitle() {
        return title;
    }

    public AuthorBindingModel getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBindingModel setAuthor(AuthorBindingModel author) {
        this.author = author;
        return this;
    }

    public BookBindingModel setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }
}
