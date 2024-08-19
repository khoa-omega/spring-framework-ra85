package com.vti.kshop.service;

import com.vti.kshop.dto.UserDto;
import com.vti.kshop.form.UserCreateForm;

import java.security.Principal;

public interface UserService {
    UserDto login(Principal username);

    UserDto create(UserCreateForm form);
}