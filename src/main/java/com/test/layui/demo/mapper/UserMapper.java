package com.test.layui.demo.mapper;

import com.test.layui.demo.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    public User Login(User user);

    public List<Object> getUserList(User user);

    public Integer deleteUserByid(Integer id);

    @Select("select count(*) from user where name=#{name}")
    public int checkName(String usernme);
    public int register(User user);
}
