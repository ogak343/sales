package com.example.sales.service;

import com.example.sales.dto.CustomerCreateDto;
import com.example.sales.dto.UserRespDto;
import com.example.sales.dto.UserUpdateDto;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    @Transactional
    UserRespDto create(CustomerCreateDto createDto);

    UserRespDto findById(Long id);

    UserRespDto update(Long id, UserUpdateDto updateDto);

    Long delete(Long id);

    UserRespDto confirm(String username, String code);
}
