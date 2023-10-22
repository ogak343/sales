package com.example.sales.service;

import com.example.sales.dto.CustomerCreateDto;

public interface NotificationService {
    void send(CustomerCreateDto createDto, int code);
}
