package bg.softuni.books.model.binding;

public class AuthorBindingModel {

    private String name;

    public AuthorBindingModel() {
    }

    public String getName() {
        return name;
    }

    public AuthorBindingModel setName(String name) {
        this.name = name;
        return this;
    }
}
