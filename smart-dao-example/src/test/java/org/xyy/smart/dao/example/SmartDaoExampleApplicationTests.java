package org.xyy.smart.dao.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xyy.smart.dao.example.entity.User;
import org.xyy.smart.dao.example.mapper.UserMapper;
import org.xyy.smart.dao.example.query.UserQuery;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmartDaoExampleApplicationTests {
	private Logger logger = LoggerFactory.getLogger(SmartDaoExampleApplicationTests.class);

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void load() {
		User user = userMapper.load(2L);
		System.out.println(user);
	}

	@Test
	public void insert() {
		User user = new User();
		user.setName("asd");
		user.setAge(99);
		user.setIsGirl(1);
		user.setCreatetime(new Date());
		userMapper.insert(user);

		for(int i = 0; i<30; i++){
			user.setAge(i+12);
			user.setName("asdf" + i);
			userMapper.insert(user);
		}
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

	@Test
	public void testQuery() {
		logger.info("test query ----------------  ");
		UserQuery userQuery = new UserQuery();

		Long[] ids = new Long[]{1L,2L,3L};
		userQuery.setIdArray(ids);

		userQuery.setPageSize(10);
		userQuery.setIsGirl(1);
		//userQuery.setName("asdf0");



		List<User> users = userMapper.queryList(userQuery);
		System.out.println(users.size());
		System.out.println(users);
	}

}
