package com.test.layui.demo.controller;

import com.test.layui.demo.pojo.DataEntity;

import com.test.layui.demo.pojo.DataListEntity;
import com.test.layui.demo.pojo.User;

import com.test.layui.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {


    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/mainlist")
    public DataListEntity mainlist() {

        DataListEntity userLiStEntity = new DataListEntity();
        userLiStEntity.setCode(0);
        userLiStEntity.setCount(20);
        List<Object> userlist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataEntity entity = new DataEntity();
            entity.setUserName("hukun");
            entity.setUserEmail("hukun@163.com");
            entity.setUserSex("男");
            entity.setUsersId("10");
            entity.setUserGrade("青铜 " + i);
            entity.setUserStatus("0");
            entity.setUserEndTime("2018-11-11 15:22:33");
            userlist.add(entity);
        }

        userLiStEntity.setData(userlist);


        return userLiStEntity;
    }


//    @RequestMapping("/")
//    public String loginpage() {
//        return "/test/login.html";
//
//    }

    @Autowired
    HttpServletRequest request;

    @ResponseBody
    @RequestMapping("/login")
    public User loginprc(User user) {
        User userl = userService.Login(user);
        if (userl != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userl);

        }
        return userl;
    }


//    @ResponseBody
//    @RequestMapping(value = "/userlist", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    public DataListEntity userlist(@RequestBody String userp) {
//    }

    @ResponseBody
    @RequestMapping(value = "/userlist")

    public DataListEntity userlist(HttpServletRequest request, String username, String major) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> map = new HashMap<>();

        DataListEntity dateLiStEntity = new DataListEntity();
        User user = new User();
        user.setName(username);
        user.setMajor(major);
        List<Object> users = userService.getUserList(user);
        dateLiStEntity.setCode(0);
        dateLiStEntity.setData(users);
        return dateLiStEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUser")
    public DataListEntity deleteUser(Integer uvid) {
        DataListEntity dateLiStEntity = new DataListEntity();
        User user = new User();
//        user.setName(username);
//        user.setMajor(major);
        Integer reid = userService.deleteUserByid(uvid);
        dateLiStEntity.setCode(0);
        dateLiStEntity.setState(1);
        return dateLiStEntity;
    }

    @RequestMapping("checkUser")
    @ResponseBody
    public int checkUser(String username) {

        int count = userService.checkName(username);
        return count;
    }


    @RequestMapping("register")
    @ResponseBody
    public int register(User user) {

        int count = userService.register(user);
        return count;
    }


//
//    @ResponseBody
//    @RequestMapping(value = "/userlist", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    public DataListEntity userlist(@RequestBody String userp) {
//
//        System.out.println(userp);
//
//        DataListEntity dateLiStEntity = new DataListEntity();
//
//
////        String name = request.getParameter("username");
////        String major = request.getParameter("major");
////        User user = new User();
////         User user = new User();
//        List<Object> users = userService.getUserList(null);
//        dateLiStEntity.setCode(0);
//        dateLiStEntity.setData(users);
//
//        return dateLiStEntity;


//}

}
