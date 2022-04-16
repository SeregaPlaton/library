package library.libraryEx.service;

import library.libraryEx.entity.Users;
import library.libraryEx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;
    private PublicationService service;

    @Autowired
    public UserServiceImpl(UserRepository repository, PublicationService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void takeBook(Users users) {
        if(service.countAvailableBooks() > 0) {
            repository.save(users);
        }
    }

    @Override
    public void awayBook(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Users> get(int id) {
        return repository.findById(id);
    }
}
