package library.publication.entity;


import library.visitor.entity.Visitor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "PUBLICATION")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", length = 1500)
    private String description;

    @ManyToMany
    private List<Visitor> visitors = new ArrayList<>();

    @Column(name = "AMOUNT_OF_BOOKS", nullable = false)
    private int amountOfBooks;
}
