package com.test.layui.demo.service;


import com.test.layui.demo.pojo.User;

import java.util.List;

public interface UserService {
   public User Login(User user);
   public List<Object> getUserList(User user);
   public Integer deleteUserByid(Integer id);
   public int checkName(String usernme);
   public int register(User user);
}
