package com.example.sales.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class ConfirmationCodeEntity {
    @Id
    private Long id;
    private int code;
    @Column(name = "created_at", insertable = false, updatable = false)
    private OffsetDateTime createdAt;
    private OffsetDateTime expiredAt;
    @Column(name = "created_at")
    private OffsetDateTime confirmedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
