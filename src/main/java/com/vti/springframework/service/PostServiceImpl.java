package com.vti.springframework.service;

import com.vti.springframework.entity.Post;
import com.vti.springframework.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Long id, Post post) {
        var optional = postRepository.findById(id);
        if (optional.isEmpty())
            return null;
        var old = optional.get();
        old.setTitle(post.getTitle());
        old.setDescription(post.getDescription());
        old.setContent(post.getContent());
        return postRepository.save(old);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
