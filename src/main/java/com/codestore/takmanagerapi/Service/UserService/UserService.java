package com.codestore.takmanagerapi.Service.UserService;

import com.codestore.takmanagerapi.Dto.UserLoginDto;
import com.codestore.takmanagerapi.Dto.UserRegisterDto;
import com.codestore.takmanagerapi.entity.UserEntity;

public interface UserService {
    void registerUser(UserRegisterDto dto);
    UserEntity login(UserLoginDto dto);
}
