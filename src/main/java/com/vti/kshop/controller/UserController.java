package com.vti.kshop.controller;

import com.vti.kshop.dto.UserDto;
import com.vti.kshop.form.UserCreateForm;
import com.vti.kshop.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Validated
@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/api/v1/auth/login")
    public UserDto login(Principal principal) {
        return userService.login(principal);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/users")
    public UserDto create(
            @RequestBody @Valid UserCreateForm form
    ) {
        return userService.create(form);
    }
}