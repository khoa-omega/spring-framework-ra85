package com.vti.springframework.service;

import com.vti.springframework.dto.PostDto;
import com.vti.springframework.form.PostCreateForm;
import com.vti.springframework.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<PostDto> findAll(Pageable pageable);

    PostDto findById(Long id);

    PostDto create(PostCreateForm form);

    PostDto update(Long id, PostUpdateForm form);

    void deleteById(Long id);
}
