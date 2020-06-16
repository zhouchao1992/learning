package com.zc.dockercompose;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zc.dockercompose.mapper")
public class DockercomposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockercomposeApplication.class, args);
    }

}
