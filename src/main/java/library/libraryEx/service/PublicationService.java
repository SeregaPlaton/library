package library.libraryEx.service;


import library.libraryEx.entity.Publication;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublicationService {

    void save(Publication publication);
    List<Publication> findByDescription(String name);
    List<Publication> findByName(String name);
    List<Publication> findAll(int pageStart);
    int countBooks();
    int countTakeBooks();
    int countAvailableBooks();
}
