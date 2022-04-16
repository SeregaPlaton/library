package library.libraryEx.service;

import library.libraryEx.entity.Users;

import java.util.Optional;

public interface UserService {

    void takeBook(Users users);
    void awayBook(int id);
    Optional<Users> get(int id);

}
