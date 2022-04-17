package library.publication.mapper;

import library.publication.dto.input.PublicationCreateInput;

import library.publication.dto.input.PublicationInput;
import library.publication.dto.input.PublicationUpdateInput;
import library.publication.dto.output.PublicationOutput;
import library.publication.entity.Publication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublicationMapper {

    public Publication fromInput(PublicationCreateInput input) {
        Publication entity = new Publication();
        setBasicAgentFields(input, entity);
        return entity;
    }

    public Publication fromInput(PublicationUpdateInput input, Publication entity) {
        setBasicAgentFields(input, entity);
        return entity;
    }

    public PublicationOutput toOutput(Publication entity) {

        return PublicationOutput.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .amountOfBooks(entity.getAmountOfBooks())
                .build();
    }

    private void setBasicAgentFields(PublicationInput input, Publication entity) {
        entity.setName(input.getName());
        entity.setDescription(input.getDescription());
        entity.setAmountOfBooks(input.getAmountOfBooks());
    }

}
