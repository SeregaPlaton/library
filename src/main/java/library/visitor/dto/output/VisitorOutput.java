package library.visitor.dto.output;

import library.publication.entity.Publication;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class VisitorOutput {
    private final Long id;
    List<Publication> publications;
}
