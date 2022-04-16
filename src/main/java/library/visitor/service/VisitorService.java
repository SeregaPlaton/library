package library.visitor.service;

import library.publication.dto.input.PublicationUpdateInput;
import library.publication.dto.output.PublicationOutput;
import library.publication.entity.Publication;
import library.visitor.dto.input.VisitorInput;
import library.visitor.dto.output.VisitorOutput;
import library.visitor.entity.Visitor;
import library.visitor.mapper.VisitorMapper;
import library.visitor.repository.VisitorRepository;
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
public class VisitorService {
    private final VisitorRepository visitorRepository;
    private final VisitorMapper mapper;

    public VisitorOutput findById(Long id) {
        return mapper.toOutput(findEntityById(id));
    }

    public List<VisitorOutput> findAll() {
        return visitorRepository.findAll()
                .stream()
                .map(mapper::toOutput)
                .collect(Collectors.toList());
    }

    public Page<VisitorOutput> findAll(Pageable pageable) {
        return visitorRepository.findAll(pageable)
                .map(mapper::toOutput);
    }

    @Transactional
    public ResponseEntity<VisitorOutput> createVisitor(VisitorInput input) {
        Visitor visitor = mapper.fromInput(input);

        Visitor savedVisitor = visitorRepository.save(visitor);
        return ResponseEntity.ok(
                mapper.toOutput(savedVisitor));
    }

    public Visitor findEntityById(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no agent with ID = %s", id)));
    }

    public ResponseEntity<VisitorOutput> updateVisitor(Long id, VisitorInput input) {
        Visitor visitor = findEntityById(id);
        Visitor updatedVisitor = mapper.fromInput(input, visitor);
        Visitor updatedAndSavedVisitor = visitorRepository.save(updatedVisitor);

        return ResponseEntity.ok(
                mapper.toOutput(updatedAndSavedVisitor));
    }

    public ResponseEntity<VisitorOutput> delete(Long id, VisitorInput input) {
        Visitor visitor = findEntityById(id);
        Visitor visitorDelete = mapper.deletePublic(input, visitor);
        Visitor visitorDeleteAndUpdate = visitorRepository.save(visitorDelete);
        return ResponseEntity.ok(
                mapper.toOutput(visitorDeleteAndUpdate));
    }
}
