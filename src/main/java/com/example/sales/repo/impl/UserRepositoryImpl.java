package com.example.sales.repo.impl;

import com.example.sales.commons.exception.BaseExceptionModel;
import com.example.sales.dao.UserDao;
import com.example.sales.mapper.UserMapper;
import com.example.sales.model.User;
import com.example.sales.repo.UserRepository;
import org.springframework.stereotype.Component;

import static com.example.sales.commons.constants.Error.USER_NOT_FOUND;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final UserDao dao;
    private final UserMapper userMapper;

    public UserRepositoryImpl(UserDao dao, UserMapper userMapper) {
        this.dao = dao;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User model) {
        return userMapper.toModel(dao.save(userMapper.toEntity(model)));
    }

    @Override
    public User findById(Long id) {
        return userMapper.toModel(dao.findById(id).orElseThrow(() -> BaseExceptionModel.details(USER_NOT_FOUND)));
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.toModel(dao.findByUsername(username)
                .orElseThrow(() -> BaseExceptionModel.details(USER_NOT_FOUND)));
    }

    @Override
    public boolean existsByUsername(String username) {
        return dao.existsByUsername(username);
    }

    @Override
    public boolean existsById(Long id) {
        return dao.existsById(id);
    }
}
