package library.visitor.mapper;

import library.publication.entity.Publication;
import library.publication.repository.PublicationRepository;
import library.visitor.dto.input.VisitorInput;
import library.visitor.dto.output.VisitorOutput;
import library.visitor.entity.Visitor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VisitorMapper {
    @Autowired
    private PublicationRepository repository;

    public Visitor fromInput(VisitorInput input) {
        Visitor visitor = new Visitor();
        visitor.addPublication(repository.findByName(input.getPublicationName()));
        return visitor;
    }

    public VisitorOutput toOutput(Visitor entity) {

        return VisitorOutput.builder()
                .id(entity.getId())
                .publications(entity.getPublications())
                .build();
    }

    public Visitor fromInput(VisitorInput input, Visitor entity) {
         setVisitorFields(input, entity);
         return entity;
    }

    private void setVisitorFields(VisitorInput input, Visitor entity) {
        entity.addPublication(repository.findByName(input.getPublicationName()));
    }

    public Visitor deletePublic(VisitorInput input, Visitor entity) {
       deleteVisitorFields(input, entity);
       return entity;
    }
    private void deleteVisitorFields(VisitorInput input, Visitor entity) {
        entity.deletePublication(repository.findByName(input.getPublicationName()));
    }
}
