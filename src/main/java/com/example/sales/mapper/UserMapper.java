package com.example.sales.mapper;

import com.example.sales.dto.CustomerCreateDto;
import com.example.sales.dto.UserRespDto;
import com.example.sales.dto.UserUpdateDto;
import com.example.sales.entity.UserEntity;
import com.example.sales.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(implementationName = "UserMapperImpl", componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "active", constant = "false")
    @Mapping(target = "role", constant = "CUSTOMER")
    @Mapping(target = "number.number", source = "number")
    User toModel(CustomerCreateDto createDto);

    User toModel(UserUpdateDto updateDto);

    UserRespDto toResp(User user);

    @Mapping(target = "authorities", ignore = true)
    void update(@MappingTarget User entity, User model);

    UserEntity toEntity(User model);

    User toModel(UserEntity save);
}
