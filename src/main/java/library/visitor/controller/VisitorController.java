package library.visitor.controller;


import library.publication.entity.Publication;

import library.visitor.dto.input.VisitorInput;

import library.visitor.dto.output.VisitorOutput;
import library.visitor.entity.Visitor;
import library.visitor.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitors")
@RequiredArgsConstructor
public class VisitorController {
    private final VisitorService visitorService;

    /**
     * Find all visitors
     *
     * @return List of visitors
     */
    @GetMapping
    public List<VisitorOutput> findVisitors() {
        return visitorService.findAll();
    }

    /**
     * Find specific visitor
     *
     * @param id required visitor ID
     * @return Visitor for specified ID
     */
    @GetMapping("/{id}")
    public VisitorOutput findVisitorById(@PathVariable("id") Long id) {
        return visitorService.findById(id);
    }

    /**
     * Find all visitors page
     *
     * @param pageable pagination params
     * @return Page of visitors
     */
    @GetMapping(params = {"page", "size"})
    public Page<VisitorOutput> findVisitors(Pageable pageable) {
        return visitorService.findAll(pageable);
    }

    /**
     * Create new visitor
     *
     * @param input visitor initial data
     */
    @PostMapping
    public ResponseEntity<VisitorOutput> createVisitor(@RequestBody VisitorInput input) {
        return visitorService.createVisitor(input);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VisitorOutput> updatePublication(@PathVariable("id") Long id, @RequestBody VisitorInput input) {
        return visitorService.updateVisitor(id, input);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VisitorOutput> deletePublic(@PathVariable("id") Long id, @RequestBody VisitorInput input) {
       return visitorService.delete(id, input);
    }
    @GetMapping("/fullId")
    public List<Publication> publicId() {
        return visitorService.publicationsId();
    }
}
