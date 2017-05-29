package org.xyy.smart.dao.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xyy.smart.dao.example.entity.User;
import org.xyy.smart.dao.example.mapper.UserMapper;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmartDaoExampleApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void load() {
		User user = userMapper.load(1L);
		System.out.println(user);
	}

	@Test
	public void insert() {
		User user = new User();
		user.setName("asd");
		user.setAge(99);
		user.setIsGirl(false);
		user.setCreatetime(new Date());
		userMapper.insert(user);
	}

	@Test
	public void delete() {
		userMapper.delete(1L);
	}

	@Test
	public void update() {
		User user = new User();
		user.setId(2L);
		user.setName("xxxxx");
		userMapper.update(user);
		System.out.println(user);
	}

}
