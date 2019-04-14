package indi.liujunchen.admin.modules.generator.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 检查项目管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 10:02:44
 */
public class ProjectmanagementEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//名称
	private String name;
	//检查内容描述
	private String subject;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
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
	 * 设置：检查内容描述
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 获取：检查内容描述
	 */
	public String getSubject() {
		return subject;
	}
}
