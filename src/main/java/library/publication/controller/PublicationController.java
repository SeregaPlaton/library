package library.publication.controller;

import library.publication.dto.input.PublicationCreateInput;
import library.publication.dto.input.PublicationUpdateInput;
import library.publication.dto.output.PublicationOutput;
import library.publication.entity.Publication;
import library.publication.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publications")
@RequiredArgsConstructor
public class PublicationController {
    private final PublicationService publicationService;

    /**
     * Find all publications
     *
     * @return List of publications
     */
    @GetMapping
    public List<PublicationOutput> findPublications() {
        return publicationService.findAll();
    }

    /**
     * Find specific publication
     *
     * @param id required publication ID
     * @return Publication for specified ID
     */
    @GetMapping("/{id}")
    public PublicationOutput findPublicationById(@PathVariable("id") Long id) {
        return publicationService.findById(id);
    }

    /**
     * Find all publications page
     *
     * @param pageable pagination params
     * @return Page of publications
     */
    @GetMapping(params = {"page", "size"})
    public Page<PublicationOutput> findPublications(Pageable pageable) {
        return publicationService.findAll(pageable);
    }

    /**
     * Create new publication
     *
     * @param input publication initial data
     */
    @PostMapping
    public ResponseEntity<PublicationOutput> createPublication(@RequestBody PublicationCreateInput input) {
        return publicationService.createPublication(input);
    }

    /**
     * Update existing publication
     *
     * @param id    ID of publication to be updated
     * @param input publication update data
     */
    @PatchMapping("/{id}")
    public ResponseEntity<PublicationOutput> updatePublication(@PathVariable("id") Long id, @RequestBody PublicationUpdateInput input) {
        return publicationService.updatePublication(id, input);
    }

    @GetMapping("/findName/{name}")
    public List<PublicationOutput> findPublicationsName(@PathVariable("name") String name) {
        return publicationService.findPublicationName(name);
    }

}
