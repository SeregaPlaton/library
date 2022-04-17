package library.visitor.repository;

import library.publication.entity.Publication;
import library.visitor.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    Visitor getById(Long id);

    @Query("SELECT v.publications FROM Visitor v join v.publications p")
    List<Publication> countTakeBooks();
}
