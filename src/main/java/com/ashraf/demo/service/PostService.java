package com.ashraf.demo.service;

import com.ashraf.demo.model.Post;
import com.ashraf.demo.model.User;
import com.ashraf.demo.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;


    public List<Post> getAllPosts() {
        return postRepo.findAll();

    }

    public List<Post> getPostsByUserEmail(String email) {
        return postRepo.findByAuthorEmail(email);
    }

    public Post creatPost(Long id, String title, String content, User user) {
        Post post = new Post();
        post.setTitle(title);

        post.setContent(content);
        post.setUser(user);

        return postRepo.save(post);
    };
}
