package com.example.sales.service.imp;

import com.example.sales.dto.CustomerCreateDto;
import com.example.sales.service.NotificationService;
import org.springframework.stereotype.Component;

@Component("MAIL")
public class MailServiceImpl implements NotificationService {
    @Override
    public void send(CustomerCreateDto createDto, int code) {

    }
}
