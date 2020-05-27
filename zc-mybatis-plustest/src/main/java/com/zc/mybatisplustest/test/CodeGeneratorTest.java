package com.zc.mybatisplustest.test;

import com.zc.common.utils.CodeGenerator;

public class CodeGeneratorTest {
    public static void main(String[] args) {
        String auth="zc";
        String jdbcurl="jdbc:mysql://129.28.158.68:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8";
        String jdbcdriver="com.mysql.cj.jdbc.Driver";
        String username="root";
        String password="123456";
        String projectname="zc-mybatis-plustest";
        String packagename="com.zc.mybatisplustest";//ums_admin
        CodeGenerator.codeGenerator(auth,jdbcurl,jdbcdriver,username,password,projectname,packagename);
    }
}
