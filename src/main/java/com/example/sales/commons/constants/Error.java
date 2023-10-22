package com.example.sales.commons.constants;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Error {
    CODE_EXPIRED(400),
    NOT_PROVIDED_ALL_REQUIRED_FIELDS(400),
    USER_ALREADY_CONFIRMED(400),
    WRONG_CREDENTIALS(401),
    INCORRECT_CODE(401),
    USER_NOT_FOUND(404),
    USER_OR_CODE_NOT_FOUND(404),
    CODE_ALREADY_USED(409),
    USERNAME_TAKEN(409);

    private final int code;

    Error(int code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return HttpStatus.valueOf(this.code);
    }
}
