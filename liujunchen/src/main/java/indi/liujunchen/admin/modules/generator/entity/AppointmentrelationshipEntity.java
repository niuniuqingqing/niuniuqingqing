package indi.liujunchen.admin.modules.generator.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 关系表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 11:08:12
 */
public class AppointmentrelationshipEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//预约
	private String appointment;
	//检查项目
	private String projectmanagement;
	//科室
	private String departmentmanagement;

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
	 * 设置：预约
	 */
	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}
	/**
	 * 获取：预约
	 */
	public String getAppointment() {
		return appointment;
	}
	/**
	 * 设置：检查项目
	 */
	public void setProjectmanagement(String projectmanagement) {
		this.projectmanagement = projectmanagement;
	}
	/**
	 * 获取：检查项目
	 */
	public String getProjectmanagement() {
		return projectmanagement;
	}
	/**
	 * 设置：科室
	 */
	public void setDepartmentmanagement(String departmentmanagement) {
		this.departmentmanagement = departmentmanagement;
	}
	/**
	 * 获取：科室
	 */
	public String getDepartmentmanagement() {
		return departmentmanagement;
	}
}
