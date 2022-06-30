package bg.softuni.books.model.view;

import bg.softuni.books.model.entity.Author;

public class BookViewModel {

    private String title;

    private AuthorViewModel author;

    private String isbn;

    public BookViewModel() {
    }

    public String getTitle() {
        return title;
    }

    public BookViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public AuthorViewModel getAuthor() {
        return author;
    }

    public BookViewModel setAuthor(AuthorViewModel author) {
        this.author = author;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookViewModel setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }
}
