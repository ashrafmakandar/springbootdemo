package com.ashraf.demo.controller;

import com.ashraf.demo.dto.LoginResponse;
import com.ashraf.demo.service.UserService;
import com.ashraf.demo.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    @GetMapping("/{id}")
    public  User getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @GetMapping("/login/{email}")
    public  User getByEmail(@PathVariable String email) {
        return service.Login(email);
    }

@GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpSession
                                   session) {
      try {
          LoginResponse loginResponse= service.getUser(user.getName(), user.getEmail());
          if(loginResponse!=null) {
              session.setAttribute("user", user);
              return ResponseEntity.ok(loginResponse);
          }
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");

      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
      }
    };


    @PutMapping("/{id}")
    public User updateuser(@PathVariable Long id,@RequestBody User user) {

        return service.updateUser(id, user);
    }
}
