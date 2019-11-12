package com.jk;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jk.mapper")
public class ZookpeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookpeDemoApplication.class, args);
    }

}
