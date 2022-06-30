package bg.softuni.books.web;

import bg.softuni.books.model.view.BookViewModel;
import bg.softuni.books.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<BookViewModel>> getAllBooks() {

        List<BookViewModel> books = this.bookService.findAll();

        if (books.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity
                .ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookViewModel> getBookById(@PathVariable("id") Long bookId) {

        Optional<BookViewModel> optBook = this.bookService.findById(bookId);

        if (optBook.isEmpty()) {

            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity
                .ok(optBook.get());
    }
}
