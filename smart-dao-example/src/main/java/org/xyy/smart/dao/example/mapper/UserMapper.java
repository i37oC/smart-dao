package org.xyy.smart.dao.example.mapper;

import java.util.List;
import org.xyy.smart.dao.example.entity.User;
import org.xyy.smart.dao.example.query.UserQuery;

public interface UserMapper  {
	/***/
	User load(Long id);

	/***/
	void insert(User user);

	/***/
	void update(User user);

		
	/***/
	void delete(Long id);

	/***/
	List<User> queryList(UserQuery userQuery);

	/***/
	int queryCount(UserQuery userQuery);
}