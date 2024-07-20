package com.manish.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDto {
    private Long userId;
    private String message;
    private String status;
}
