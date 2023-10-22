package com.example.sales.service.imp;

import com.example.sales.commons.constants.Error;
import com.example.sales.commons.constants.NotificationType;
import com.example.sales.commons.exception.BaseExceptionModel;
import com.example.sales.dto.CustomerCreateDto;
import com.example.sales.dto.UserRespDto;
import com.example.sales.dto.UserUpdateDto;
import com.example.sales.mapper.CodeMapper;
import com.example.sales.mapper.UserMapper;
import com.example.sales.model.ConfirmationCode;
import com.example.sales.repo.UserRepository;
import com.example.sales.repo.CodeRepository;
import com.example.sales.service.NotificationService;
import com.example.sales.service.UserService;
import com.example.sales.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final CodeMapper codeMapper;
    private final UserValidator userValidator;
    private final UserRepository userRepository;
    private final Map<String, NotificationService> services;
    private final CodeRepository codeRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserRespDto create(CustomerCreateDto createDto) {

        var model = userMapper.toModel(createDto);
        userValidator.validateCreate(createDto);

        model.setPassword(passwordEncoder.encode(model.getPassword()));
        var user = userRepository.save(model);
        var code = new ConfirmationCode(
                new Random().nextInt(100000, 999999),
                OffsetDateTime.now(),
                OffsetDateTime.now().plusMinutes(5),
                user
        );
        getService(createDto.getType()).send(createDto, code.getCode());
        return userMapper.toResp(user);
    }

    @Override
    public UserRespDto findById(Long id) {
        return userMapper.toResp(userRepository.findById(id));
    }

    @Override
    public UserRespDto update(Long id, UserUpdateDto updateDto) {

        var entity = userRepository.findById(id);
        userMapper.update(entity, userMapper.toModel(updateDto));
        return userMapper.toResp(userRepository.save(entity));
    }

    @Override
    public Long delete(Long id) {
        userValidator.validateDelete(id);
        userRepository.delete(id);

        return id;
    }

    @Override
    public UserRespDto confirm(String username, String code) {

        var model = codeMapper.toModel(codeRepository.findByUsername(username)
                .orElseThrow(() -> BaseExceptionModel.details(Error.USER_OR_CODE_NOT_FOUND)));
        userValidator.validateConfirm(model);

        if (!passwordEncoder.matches(code, model.getUser().getPassword())) {
            throw BaseExceptionModel.details(Error.INCORRECT_CODE);
        }
        model.getUser().setActive(true);
        userRepository.save(model.getUser());
        codeRepository.save(codeMapper.toEntity(model));
        return userMapper.toResp(model.getUser());
    }

    private NotificationService getService(NotificationType type) {
        return services.get(type.name());
    }
}
