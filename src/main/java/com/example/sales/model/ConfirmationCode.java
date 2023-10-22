package com.example.sales.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class ConfirmationCode {

    private Long id;
    private int code;
    private OffsetDateTime createdAt;
    private OffsetDateTime expiredAt;
    private OffsetDateTime confirmedAt;
    private User user;

    public ConfirmationCode(int code, OffsetDateTime createdAt, OffsetDateTime expiredAt, User user) {
        this.code = code;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.user = user;
    }
}
