package indi.liujunchen.admin.modules.generator.entity;

import indi.liujunchen.admin.modules.sys.entity.SysUserEntity;

import java.io.Serializable;

import org.apache.shiro.SecurityUtils;

/**
 * 课程查询
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-04 22:04:44
 */
public class ScheduleCardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// id
	private String id;
	// 时间
	private String shijian;

	private String shijianStart;

	private String shijianEnd;
	// 教室
	private String classroom;
	// 教师
	private String teacher;
	// 科目
	private String subject;

	private String approveStatus;
	
	private String category;

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
	 * 设置：时间
	 */
	public void setShijian(String shijian) {
		this.shijian = shijian;
	}

	/**
	 * 获取：时间
	 */
	public String getShijian() {
		return shijian;
	}

	/**
	 * 设置：教室
	 */
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	/**
	 * 获取：教室
	 */
	public String getClassroom() {
		return classroom;
	}

	/**
	 * 设置：教师
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	/**
	 * 获取：教师
	 */
	public String getTeacher() {
		
		if(teacher==null){
			 SysUserEntity user = (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
			 if(user!=null){
				 String userName = user.getUsername();
				 teacher=userName;
			 }
		 
		}
		return teacher;
	}

	/**
	 * 设置：科目
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 获取：科目
	 */
	public String getSubject() {
		return subject;
	}

	public String getApproveStatus() {
		if (approveStatus == null) {
			approveStatus = "未提交";
		}
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getShijianStart() {
		return shijianStart;
	}

	public void setShijianStart(String shijianStart) {
		this.shijianStart = shijianStart;
	}

	public String getShijianEnd() {
		return shijianEnd;
	}

	public void setShijianEnd(String shijianEnd) {
		this.shijianEnd = shijianEnd;
	}

	public String getCategory() {
		if(category==null){
			category="课程表";
		}
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
