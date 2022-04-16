package library.libraryEx.service;


import library.libraryEx.entity.Publication;
import library.libraryEx.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationRepository repository;

    @Autowired
    public PublicationServiceImpl(PublicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Publication publication) {
        repository.save(publication);
    }

    @Override
    public List<Publication> findByName(String name) {
        return repository.findByNameContaining(name);

    }

    @Override
    public List<Publication> findByDescription(String name) {
        return repository.findByDescriptionContaining(name);

    }

    @Override
    public List<Publication> findAll(int pageStart) {
        Pageable pageable = PageRequest.of(pageStart, 10);
        Page<Publication> page = repository.findAll(pageable);
        return page.toList();
    }

    @Override
    public int countBooks() {
        return repository.countBooks();
    }

    @Override
    public int countTakeBooks() {
        return repository.countTakeBooks();
    }

    @Override
    public int countAvailableBooks() {
        return countBooks() - countTakeBooks();
    }
}
