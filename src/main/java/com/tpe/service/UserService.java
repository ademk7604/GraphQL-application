package com.tpe.service;

import com.tpe.exception.UserNotFoundException;
import com.tpe.model.User;
import com.tpe.model.UserRequest;
import com.tpe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //Constructer basic injecktion da yaptik
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("user not found!"));
    }

    public User createUser(UserRequest userRequest) {
        User user =
                User.builder()
                .username(userRequest.getUsername())
                .mail(userRequest.getMail())
                .role(userRequest.getRole())
                .build();
        return userRepository.save(user);
    }

    public User updateUser(UserRequest userRequest) {
        User existing = getUserById(userRequest.getId());
        existing.setRole(userRequest.getRole());
        existing.setUsername(userRequest.getUsername());
        existing.setMail(userRequest.getMail());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        User existing = getUserById(id);
        userRepository.delete(existing);
    }
}
