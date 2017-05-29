package org.xyy.smart.dao.example.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * @author xyy
 * @version 1.0 2017/5/25.
 * @since 1.0
 */
public class User {

		
	/**
     * 主键ID
     */
	private Long id;
	
	
	private Date createtime;
	
	
	private Boolean isGirl;
	
	/**
     * 名字
     */
	private String name;
	
	/**
     * 年龄
     */
	private Integer age;
	
	/**
     * 住址
     */
	private String address;
	
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public Boolean getIsGirl() {
		return isGirl;
	}

	public void setIsGirl(Boolean isGirl) {
		this.isGirl = isGirl;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [ id=" + id + ", createtime=" + createtime + ", isGirl=" + isGirl + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
}
