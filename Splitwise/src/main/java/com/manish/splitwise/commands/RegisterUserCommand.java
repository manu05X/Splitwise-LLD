package com.manish.splitwise.commands;

import com.manish.splitwise.controllers.UserController;
import com.manish.splitwise.dtos.RegisterUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RegisterUserCommand implements Command{

    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }


    @Override
    public boolean matches(String input) {
        List<String> inputWord = Arrays.stream(input.split(" ")).toList();

//        if(inputWord.size() == 4 || inputWord.get(0).equalsIgnoreCase("Register")) {
        if(inputWord.size() == 4 || inputWord.get(0).equalsIgnoreCase(CommandKeywords.REGISTER_USER)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();

        String password = inpWords.get(1);
        String phoneNumber = inpWords.get(2);
        String username = inpWords.get(3);

        RegisterUserRequestDto request = new RegisterUserRequestDto();
        request.setPassword(password);
        request.setPhone(phoneNumber);
        request.setUserName(username);


        userController.registerUser(request);
        // call user controller and get our action done
    }
}
