package com.example.sales.mapper;

import com.example.sales.entity.ConfirmationCodeEntity;
import com.example.sales.model.ConfirmationCode;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(implementationName = "CodeMapperImpl", componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CodeMapper {
    ConfirmationCode toModel(ConfirmationCodeEntity confirmationCodeEntity);

    ConfirmationCodeEntity toEntity(ConfirmationCode model);
}
