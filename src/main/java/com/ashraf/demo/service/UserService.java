package com.ashraf.demo.service;


import com.ashraf.demo.dto.LoginResponse;

import com.ashraf.demo.model.User;
import com.ashraf.demo.repository.PostRepo;
import com.ashraf.demo.repository.UserRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
    private final PostRepo postRepo;

    public UserService(UserRepository repository, PostRepo postRepo) {
        this.repository = repository;
        this.postRepo = postRepo;
    }

    public List<User> getAll() {


        return repository.findAll();
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User Login(String email ) {
       return repository.findUserByEmail((email));
    }

public LoginResponse getUser(String name,String email) {
    Optional<User> user= repository.findByName(name);
    if(user.isPresent() && user.get().getEmail().equals(email)) {
        return new LoginResponse("Succesfull login","200",user.get());

    }else {
        return new LoginResponse("Fail login","404",null);
    }
}


    public void delete(Long id) {
        repository.deleteById(id);
    }
    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    public User updateUser(Long id,User user) {
        User existinguser= repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        existinguser.setEmail(user.getEmail());
        existinguser.setName(user.getName());
        return repository.save(existinguser);
    }



}

