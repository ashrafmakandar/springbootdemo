package com.ashraf.demo.repository;

import com.ashraf.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public  interface PostRepo  extends JpaRepository<Post, Long> {
    List<Post> findByAuthorEmail(String email);

}
