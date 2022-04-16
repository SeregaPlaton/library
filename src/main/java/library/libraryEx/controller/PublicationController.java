package library.libraryEx.controller;


import library.libraryEx.entity.Publication;
import library.libraryEx.entity.Users;
import library.libraryEx.service.PublicationService;
import library.libraryEx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PublicationController {
    private UserService userService;
    private PublicationService service;

    @Autowired
    public PublicationController(UserService userService, PublicationService service) {
        this.userService = userService;
        this.service = service;
    }

    @PostMapping("/publications")
    public ResponseEntity<Publication> add(@RequestBody Publication publication) {
        service.save(publication);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/publications/publicationName:\\D+")
    public List<Publication> getPublicationName(String name) {
        return service.findByName(name);
    }

    @GetMapping("/publications/publicationDescription:\\D+")
    public List<Publication> getPublicationDescription(String description) {
        return service.findByDescription(description);
    }

    @GetMapping("/publications/{pageStart}")
    public List<Publication> findAll(@PathVariable int pageStart) {
        return service.findAll(pageStart);
    }

    @GetMapping("/publications/countBooks")
    public int countBooks() {
        return service.countBooks();
    }

    @GetMapping("/publications/countTakeBooks")
    public int countTakeBooks() {
        return service.countTakeBooks();
    }

    @GetMapping("/publications/countAvailableBooks")
    public int countAvailableBooks() {
        return service.countAvailableBooks();
    }

    @PostMapping("/users")
    public ResponseEntity<Users> takeBook(@RequestBody Users users) {
        userService.takeBook(users);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public void awayBook(@PathVariable("id") int id) {

        Optional<Users> user = userService.get(id);

        if(user == null){
            System.out.println("Данная книга находиться в библиотеке и ее невозможно вернуть");
        }
        userService.awayBook(id);
    }
}
