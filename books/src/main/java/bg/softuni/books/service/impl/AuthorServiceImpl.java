package bg.softuni.books.service.impl;

import bg.softuni.books.model.entity.Author;
import bg.softuni.books.repository.AuthorRepository;
import bg.softuni.books.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findByName(String name) {
        return this.authorRepository.findByName(name)
                .orElse(null);
    }
}
