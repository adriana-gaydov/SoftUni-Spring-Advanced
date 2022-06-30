package bg.softuni.books.service.impl;

import bg.softuni.books.model.binding.BookBindingModel;
import bg.softuni.books.model.entity.Book;
import bg.softuni.books.model.view.AuthorViewModel;
import bg.softuni.books.model.view.BookViewModel;
import bg.softuni.books.repository.BookRepository;
import bg.softuni.books.service.AuthorService;
import bg.softuni.books.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
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

    @Override
    public long saveBook(BookBindingModel newBook) {

        Book book = map(newBook);
        this.bookRepository.save(book);

        return book.getId();
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

    private Book map(BookBindingModel bookBindingModel) {

        return new Book()
                .setAuthor(this.authorService.findByName(bookBindingModel.getAuthor().getName()))
                .setTitle(bookBindingModel.getTitle())
                .setIsbn(bookBindingModel.getIsbn());
    }
}
