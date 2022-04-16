package library.visitor.repository;

import library.visitor.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    Visitor getById(Long id);
}
