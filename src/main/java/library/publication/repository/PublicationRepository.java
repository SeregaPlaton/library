package library.publication.repository;

import library.publication.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long>, PagingAndSortingRepository<Publication, Long> {

    Publication findByName(String name);
}
