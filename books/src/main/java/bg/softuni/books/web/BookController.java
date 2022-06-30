package bg.softuni.books.web;

import bg.softuni.books.model.binding.BookBindingModel;
import bg.softuni.books.model.view.BookViewModel;
import bg.softuni.books.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping("")
    public ResponseEntity<BookBindingModel> saveBook(@RequestBody BookBindingModel newBook,
                                                     UriComponentsBuilder uriComponentsBuilder) {

        long id = this.bookService.saveBook(newBook);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/books/{id}")
                        .build(id))
                .build();
    }
}
