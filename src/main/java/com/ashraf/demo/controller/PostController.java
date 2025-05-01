package com.ashraf.demo.controller;

import com.ashraf.demo.model.Post;
import com.ashraf.demo.model.User;
import com.ashraf.demo.repository.PostRepo;
import com.ashraf.demo.repository.UserRepository;
import com.ashraf.demo.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PostRepo postRepo;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post, HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null || sessionUser.getId() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in or not saved properly");
        }
        post.setUser(sessionUser);
        Post savedPost = postRepo.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
    List<Post> posts = postService.getAllPosts();
    return ResponseEntity.status(HttpStatus.OK).body(posts);
    }
}
