package com.test.layui.demo.service;

import com.test.layui.demo.mapper.UserMapper;
import com.test.layui.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User Login(User user) {
        return userMapper.Login(user);
    }

    @Override
    public List<Object> getUserList(User user) {
        return userMapper.getUserList(user);
    }

    @Override
    public Integer deleteUserByid(Integer id) {
        return userMapper.deleteUserByid(id);
    }

    @Override
    public int checkName(String usernme) {
        return userMapper.checkName(usernme);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }
}
