package bg.softuni.books.service;

import bg.softuni.books.model.entity.Author;

public interface AuthorService {

    Author findByName(String name);
}
