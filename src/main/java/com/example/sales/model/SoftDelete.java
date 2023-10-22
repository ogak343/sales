package com.example.sales.model;

import lombok.Data;
import lombok.ToString;

import java.time.OffsetDateTime;

@ToString
@Data
public class SoftDelete {
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime deletedAt;
}
