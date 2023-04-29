package com.tpe.service;

import com.tpe.model.User;
import com.tpe.model.UserRequest;
import com.tpe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("user not found!"));
    }

    public User createUser(UserRequest userRequest) {
        User user =
                User.builder()
                .username(userRequest.getUsername())
                .mail(userRequest.getMail())
                .role(userRequest.getRole())
                .build();


        return respository.save(user);
    }

    public User updateUser(UserRequest userRequest) {

        return null;
    }
}
