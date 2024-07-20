package com.manish.splitwise.services;

import com.manish.splitwise.exceptions.UserAlreadyExistsException;
import com.manish.splitwise.models.User;
import com.manish.splitwise.models.UserStatus;
import com.manish.splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // real model od user is returned to controller
    public User registerUser(String userName, String phone, String password) throws UserAlreadyExistsException{
        Optional<User> userOptional = userRepository.findByPhone(phone);

        if (userOptional.isPresent()) {
            if (userOptional.get().getUserStatus().equals(UserStatus.ACTIVE)) {
                throw new UserAlreadyExistsException();
            } else {
                User user = userOptional.get();
                user.setUserStatus(UserStatus.ACTIVE);
                user.setUserName(userName);
                user.setPassword(password);
                return userRepository.save(user);
            }
        }

        User user = new User();
        user.setPhone(phone);
        user.setUserName(userName);
        user.setPassword(password);
        user.setUserStatus(UserStatus.ACTIVE);

        return userRepository.save(user);
    }
}
