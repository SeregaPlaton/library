package library.publication.service;


import library.publication.dto.input.PublicationCreateInput;
import library.publication.dto.input.PublicationUpdateInput;
import library.publication.dto.output.PublicationOutput;
import library.publication.entity.Publication;
import library.publication.mapper.PublicationMapper;
import library.publication.repository.PublicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private final PublicationMapper mapper;

    public PublicationOutput findById(Long id) {
        return mapper.toOutput(findEntityById(id));
    }

    public List<PublicationOutput> findAll() {
        return publicationRepository.findAll()
                .stream()
                .map(mapper::toOutput)
                .collect(Collectors.toList());
    }
    public Page<PublicationOutput> findAll(Pageable pageable) {
        return publicationRepository.findAll(pageable)
                .map(mapper::toOutput);
    }
    @Transactional
    public ResponseEntity<PublicationOutput> createPublication(PublicationCreateInput input) {
        Publication publication = mapper.fromInput(input);

        Publication savedPublication = publicationRepository.save(publication);
        return ResponseEntity.ok(
                mapper.toOutput(savedPublication));
    }
    public ResponseEntity<PublicationOutput> updatePublication(Long id, PublicationUpdateInput input) {
        Publication publication = findEntityById(id);
        Publication updatedPublication = mapper.fromInput(input, publication);
        Publication updatedAndSavedPublication = publicationRepository.save(updatedPublication);

        return ResponseEntity.ok(
                mapper.toOutput(updatedAndSavedPublication));
    }
    public Publication findEntityById(Long id) {
        return publicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no agent with ID = %s", id)));
    }
}
