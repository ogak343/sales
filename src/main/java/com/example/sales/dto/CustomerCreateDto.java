package com.example.sales.dto;

import com.example.sales.commons.constants.NotificationType;
import lombok.Data;

import java.util.Objects;

@Data
public class CustomerCreateDto {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private NotificationType type;
    private String email;
    private String number;

    public boolean suitableToCreate() {
        return Objects.nonNull(username) && Objects.nonNull(password) && Objects.nonNull(type)
                && Objects.nonNull(email) && Objects.nonNull(number);
    }
}
