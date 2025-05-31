package com.codestore.takmanagerapi.Service.UserService;

import com.codestore.takmanagerapi.Dto.UserLoginDto;
import com.codestore.takmanagerapi.Dto.UserRegisterDto;
import com.codestore.takmanagerapi.entity.UserEntity;
import com.codestore.takmanagerapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserRegisterDto dto) {
        String hashedPassword = passwordEncoder.encode(dto.getPassword());

        UserEntity user = new UserEntity();
        user.setUsername(dto.getUsername());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    @Override
    public UserEntity login(UserLoginDto dto) {
        UserEntity user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}