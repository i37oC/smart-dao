package org.xyy.smartdao;

import java.io.Serializable;
import java.util.Date;

/**
*实体类
*/
public class User implements Serializable {
	private static final long serialVersionUID = 23123123123123343L;

		
	private String name;//
	
	private Long id;//
	
		
	/***/
	public String getName() {
		return name;
	}

	/***/
	public void setName(String name) {
		this.name = name;
	}
	
	/***/
	public Long getId() {
		return id;
	}

	/***/
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "User [ name=" + name + ", id=" + id + "]";
	}
}
