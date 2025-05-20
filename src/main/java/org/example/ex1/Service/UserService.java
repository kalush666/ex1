package org.example.ex1.Service;

import org.example.ex1.Entity.User;
import org.example.ex1.Repository.ProductRepository;
import org.example.ex1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(User user) {
        repository.save(user);
    }
    public User findUserByUserName(String userName) {
        return repository.findByUserName(userName);
    }
}
