package com.xin.userwallet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xin.userwallet.dao")
public class UserWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserWalletApplication.class, args);
    }

}
