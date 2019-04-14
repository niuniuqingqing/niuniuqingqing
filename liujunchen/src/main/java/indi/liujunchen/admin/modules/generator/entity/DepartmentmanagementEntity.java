package indi.liujunchen.admin.modules.generator.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 科室管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 10:02:43
 */
public class DepartmentmanagementEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//名称
	private String name;
	//地点
	private String place;

	/**
	 * 设置：id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：地点
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	/**
	 * 获取：地点
	 */
	public String getPlace() {
		return place;
	}
}
