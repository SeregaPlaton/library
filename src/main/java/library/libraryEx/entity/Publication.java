package library.libraryEx.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Publication {

    @Id
    int id;
    private String name;
    @Column(length = 1500)
    private String description;

    @ManyToMany(mappedBy = "publication")
    private Set<Users> users = new HashSet<>();

    private int book;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getBook() {
        return book;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBook(int book) {
        this.book = book;
    }
}
