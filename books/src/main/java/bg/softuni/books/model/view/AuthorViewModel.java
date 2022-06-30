package bg.softuni.books.model.view;

public class AuthorViewModel {

    private String name;

    public AuthorViewModel() {
    }

    public String getName() {
        return name;
    }

    public AuthorViewModel setName(String name) {
        this.name = name;
        return this;
    }
}
