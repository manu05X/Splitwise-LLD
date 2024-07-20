package com.manish.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String password;
    private String phone;
    private String userName;
}
// as above 3 attribute is present in executer of RegisterUserCommand