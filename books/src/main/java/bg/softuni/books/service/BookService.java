package bg.softuni.books.service;

import bg.softuni.books.model.view.BookViewModel;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<BookViewModel> findById(Long bookId);

    List<BookViewModel> findAll();
}
