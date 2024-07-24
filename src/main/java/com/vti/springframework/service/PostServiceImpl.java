package com.vti.springframework.service;

import com.vti.springframework.dto.PostDto;
import com.vti.springframework.form.PostCreateForm;
import com.vti.springframework.form.PostUpdateForm;
import com.vti.springframework.mapper.PostMapper;
import com.vti.springframework.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Override
    public List<PostDto> findAll() {
        return postRepository.findAll()
                .stream()
                .map(PostMapper::map)
                .toList();
    }

    @Override
    public PostDto findById(Long id) {
        return postRepository.findById(id)
                .map(PostMapper::map)
                .orElse(null);
    }

    @Override
    public PostDto create(PostCreateForm form) {
        var post = PostMapper.map(form);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public PostDto update(Long id, PostUpdateForm form) {
        var optional = postRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var post = optional.get();
        PostMapper.map(form, post);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
