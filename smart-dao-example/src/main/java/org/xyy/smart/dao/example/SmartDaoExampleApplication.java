package org.xyy.smart.dao.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.xyy.smart.dao.example.mapper")
public class SmartDaoExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartDaoExampleApplication.class, args);
	}
}
