package com.example.sales.validator;


import com.example.sales.commons.constants.Error;
import com.example.sales.commons.exception.BaseExceptionModel;
import com.example.sales.dto.CustomerCreateDto;
import com.example.sales.model.ConfirmationCode;
import com.example.sales.repo.UserRepository;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

import static com.example.sales.commons.constants.Error.*;

@Component
public class UserValidatorImpl implements UserValidator {

    private final UserRepository userRepository;

    public UserValidatorImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateCreate(CustomerCreateDto createDto) {

        if (!createDto.suitableToCreate()) {
            throw BaseExceptionModel.details(NOT_PROVIDED_ALL_REQUIRED_FIELDS);
        }

        boolean exists = userRepository.existsByUsername(createDto.getUsername());
        if (exists) {
            throw BaseExceptionModel.details(USERNAME_TAKEN);
        }
    }

    @Override
    public void validateDelete(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw BaseExceptionModel.details(USER_NOT_FOUND);
        }
    }

    @Override
    public void validateConfirm(ConfirmationCode model) {
        if (model.getConfirmedAt() != null) {
            throw BaseExceptionModel.details(CODE_ALREADY_USED);
        }

        if (model.getExpiredAt().isBefore(OffsetDateTime.now())) {
            throw BaseExceptionModel.details(Error.CODE_EXPIRED);
        }

        if (model.getUser().isActive()) {
            throw BaseExceptionModel.details(Error.USER_ALREADY_CONFIRMED);
        }
    }
}

