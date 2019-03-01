package com.wzq.labsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //定时任务开关
@MapperScan("com.wzq.labsystem.mapper")
public class LabSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSystemApplication.class, args);
    }

}
