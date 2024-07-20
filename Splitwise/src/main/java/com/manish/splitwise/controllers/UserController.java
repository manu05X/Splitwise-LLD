package com.manish.splitwise.controllers;

import com.manish.splitwise.dtos.RegisterUserRequestDto;
import com.manish.splitwise.dtos.RegisterUserResponseDto;
import com.manish.splitwise.exceptions.UserAlreadyExistsException;
import com.manish.splitwise.models.User;
import com.manish.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // It will take input RegisterUserRequestDto and return RegisterUserResponseDto
    public RegisterUserResponseDto registerUser(RegisterUserRequestDto request) {
        User user;
        RegisterUserResponseDto response = new RegisterUserResponseDto();

        try {
            user = userService.registerUser(
                    //real model attribute is extracted from request and passed to service
                    request.getUserName(),
                    request.getPhone(),
                    request.getPassword()
            );

            // extracting from real model to convert/built it into responseDto for sending response to client
            response.setUserId(user.getId());
            response.setStatus("SUCCESS");
        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            response.setStatus("FAILURE");
            response.setMessage(userAlreadyExistsException.getMessage());
        }

        return response;
    }
}
/*
A controller calls the service
 */