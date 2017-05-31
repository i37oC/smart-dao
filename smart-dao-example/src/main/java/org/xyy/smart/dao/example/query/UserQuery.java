package org.xyy.smart.dao.example.query;

import java.io.Serializable;
import java.util.Date;


/**
 * User查询对象
 */
public class UserQuery extends  QueryParamBase{
							
	private Long[] idArray;
					
	private Date createtimeFrom;

	private Date createtimeTo;
        			
    private int isGirl;
					
    private String name;
					
    private Integer age;
					
    private String address;
			
							
    public Long[] getIdArray() {
    	return idArray;
    }

    public void setIdArray(Long... idArray) {
    	this.idArray = idArray;
    }
					
    public Date getCreatetimeFrom() {
    	return createtimeFrom;
    }
        

    public void setCreatetimeFrom(Date createtimeFrom) {
    	this.createtimeFrom = createtimeFrom;
    }
			

    public Date getCreatetimeTo() {
    	return createtimeTo;
    }
        

    public void setCreatetimeTo(Date createtimeTo) {
    	this.createtimeTo = createtimeTo;
    }
					
    public int getIsGirl() {
    	return isGirl;
    }
        

    public void setIsGirl(int isGirl) {
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
			
}
