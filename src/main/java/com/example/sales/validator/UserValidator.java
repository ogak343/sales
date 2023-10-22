package com.example.sales.validator;

import com.example.sales.dto.CustomerCreateDto;
import com.example.sales.model.ConfirmationCode;

public interface UserValidator {
    void validateCreate(CustomerCreateDto createDto);

    void validateDelete(Long id);

    void validateConfirm(ConfirmationCode model);
}
