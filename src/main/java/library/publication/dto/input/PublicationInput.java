package library.publication.dto.input;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PublicationInput {
    private final String name;
    private final String description;
    private final int amountOfBooks;
}
