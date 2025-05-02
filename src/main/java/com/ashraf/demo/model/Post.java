package com.ashraf.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String content;
    @ManyToOne(fetch = FetchType.EAGER)
            @JoinColumn(name = "user_id")
    User author;

    public void setUser(User user) {
        this.author = user;
    }

    public User getAuthor() {
        return author;
    }
}
