package com.example.bibasedhouduan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.bibasedhouduan.dao")
public class BibasedhouduanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibasedhouduanApplication.class, args);
		System.out.println("赵智慧是个大傻蛋！");
	}
}
