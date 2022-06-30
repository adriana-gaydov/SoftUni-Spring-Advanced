package bg.softuni.books.service.impl;

import bg.softuni.books.model.entity.Book;
import bg.softuni.books.model.view.AuthorViewModel;
import bg.softuni.books.model.view.BookViewModel;
import bg.softuni.books.repository.BookRepository;
import bg.softuni.books.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<BookViewModel> findById(Long bookId) {

        return this.bookRepository.findById(bookId)
                .map(this::bookMapToView);
    }

    @Override
    public List<BookViewModel> findAll() {

        return this.bookRepository.findAll()
                .stream().map(this::bookMapToView)
                .toList();
    }


    private BookViewModel bookMapToView(Book book) {

        return new BookViewModel()
                .setTitle(book.getTitle())
                .setAuthor(authorMapToView(book))
                .setIsbn(book.getIsbn());
    }

    private AuthorViewModel authorMapToView(Book book) {
        return new AuthorViewModel()
                .setName(book.getAuthor().getName());
    }
}
