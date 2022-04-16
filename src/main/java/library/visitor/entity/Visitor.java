package library.visitor.entity;

import library.publication.entity.Publication;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "USERS")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Publication> publications = new ArrayList<>();

    public List<Publication> addPublication(Publication publication) {
        publications.add(publication);
        return publications;
    }
}
