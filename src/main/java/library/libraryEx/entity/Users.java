package library.libraryEx.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Users {
    @Id
    private int id;
    @ManyToMany
    private Set<Publication> publication = new HashSet<>();

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPublication(Set<Publication> publication) {
        this.publication = publication;
    }

    public Set<Publication> getPublication() {
        return publication;
    }
}
