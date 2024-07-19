package com.vti.springframework.service;

import com.vti.springframework.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post findById(Long id);

    Post create(Post post);

    Post update(Long id, Post post);

    void deleteById(Long id);
}
