package com.example.sales.commons.exception;

import com.example.sales.commons.constants.Error;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;

public class BaseExceptionModel extends ErrorResponseException {

    public BaseExceptionModel(HttpStatusCode status) {
        super(status);
    }

    public static BaseExceptionModel details(Error error) {
        return new BaseExceptionModel(error.getStatus());
    }
}
