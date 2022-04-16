package library.publication.dto.input;

import lombok.Getter;

@Getter
public class PublicationCreateInput extends PublicationInput {

    public PublicationCreateInput(String name, String description, int amountOfBooks) {
        super(name, description, amountOfBooks);
    }
}
