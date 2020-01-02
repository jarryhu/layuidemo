package com.test.layui.demo.pojo;

import java.util.List;

public class DataListEntity {

    /**
     * msg :
     * code : 0
     * data : [{"userSex":"女","userStatus":"0","userGrade":"倔强青铜","usersId":"1","userEndTime":"2018-11-11 15:22:33","userEmail":"123@qq.com","userName":"user12"},{"userSex":"男","userStatus":"1","userGrade":"秩序白银","usersId":"2","userEndTime":"2018-11-11 15:22:33","userEmail":"123@qq.com","userName":"asd"}]
     * count : 15
     */
    private String msg;
    private int code;
    private List<Object> data;
    private int count;
    private int state;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public List<Object> getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
