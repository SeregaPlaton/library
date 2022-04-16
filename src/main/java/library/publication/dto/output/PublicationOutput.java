package library.publication.dto.output;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PublicationOutput {
    private final Long id;
    private final String name;
    private final String description;
    private final int amountOfBooks;
}
