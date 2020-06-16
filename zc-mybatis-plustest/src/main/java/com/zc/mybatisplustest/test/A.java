package com.zc.mybatisplustest.test;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;

import java.io.Serializable;

/**
 * 用于测试Java序列化
 */
public class A implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String test="1111";

    private  String id;

    private  String name;

    private  String address;

    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
