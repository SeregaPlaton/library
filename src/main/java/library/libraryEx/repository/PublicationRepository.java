package library.libraryEx.repository;

import library.libraryEx.entity.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer>, PagingAndSortingRepository<Publication, Integer> {

    List<Publication> findByNameContaining(String name);
    List<Publication> findByDescriptionContaining(String description);
    @Query("select p.book from Publication p")
    int countBooks();
    @Query("select count(p.users) from Publication p group by p.users")
    int countTakeBooks();
}
