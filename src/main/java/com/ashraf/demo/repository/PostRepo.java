package com.ashraf.demo.repository;

import com.ashraf.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface PostRepo  extends JpaRepository<Post, Long> {

}
