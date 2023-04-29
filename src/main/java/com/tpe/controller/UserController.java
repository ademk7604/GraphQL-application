package com.tpe.controller;

import com.tpe.model.User;
import com.tpe.model.UserRequest;
import com.tpe.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    //@QueryMapping ann. ile  getAllUsers methodun scheme dan oldugunu anliyor
    //@Argument parametre girebilmemiz icin kullaniyoruz ann.
    // ResponseEntity donmememizin neden scheme yi biraz daha degistrmek zorunda olmamizdir.


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @QueryMapping
    List<User> getAllUsers(){
    return userService.getAllUsers();

    }

    @QueryMapping
    User getUserById(@Argument Long id){
        return userService.getUserById();

    }

    @MutationMapping
    User createUser(@Argument UserRequest userRequest){
        return userService.createUser(userRequest);

    }

    @MutationMapping
    User updateUser(@Argument UserRequest userRequest){
        return userService.updateUser(userRequest);

    }

    @MutationMapping
    Boolean deleteUser(@Argument Long id ){
        return userService.createUser(id);

    }


}
