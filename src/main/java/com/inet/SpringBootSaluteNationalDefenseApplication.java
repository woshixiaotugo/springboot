package com.inet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 */
@EnableTransactionManagement
@MapperScan("com.inet.mapper")
@SpringBootApplication
public class SpringBootSaluteNationalDefenseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSaluteNationalDefenseApplication.class, args);
    }

}
