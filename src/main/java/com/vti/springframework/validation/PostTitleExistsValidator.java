package com.vti.springframework.validation;

import com.vti.springframework.repository.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostTitleExistsValidator
        implements ConstraintValidator<PostTitleExists, String> {
    private PostRepository postRepository;

    @Override
    public boolean isValid(String title, ConstraintValidatorContext context) {
        return postRepository.existsByTitle(title);
    }
}
