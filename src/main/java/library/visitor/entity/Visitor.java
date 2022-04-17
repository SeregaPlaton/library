package library.visitor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import library.publication.entity.Publication;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "VISITOR")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "publication_visitor", joinColumns = @JoinColumn(name = "publication_id"),
            inverseJoinColumns = @JoinColumn(name = "visitor_id"))
    private List<Publication> publications = new ArrayList<>();

    public List<Publication> addPublication(Publication publication) {
        publications.add(publication);
        return publications;
    }

    public List<Publication>  deletePublication(Publication publication) {
        publications.remove(publication);
        return publications;
    }
}
