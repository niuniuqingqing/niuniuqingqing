package indi.liujunchen.admin.modules.generator.entity;

import indi.liujunchen.admin.modules.sys.entity.SysUserEntity;

import java.io.Serializable;

import org.apache.shiro.SecurityUtils;



/**
 * 教室查询
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-04 22:04:44
 */
public class ClassroomInquiryEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//教室号
	private String classroomNum;
	//教室类型
	private String classroomType;
	//是否预约
	private String isAppointment;

	//审核状态
	private String approveStatus;
	
	private String shijianStart;
	
	private String shijianEnd;
	private String createBy;
	
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
	 * 设置：教室号
	 */
	public void setClassroomNum(String classroomNum) {
		this.classroomNum = classroomNum;
	}
	/**
	 * 获取：教室号
	 */
	public String getClassroomNum() {
		return classroomNum;
	}
	/**
	 * 设置：教室类型
	 */
	public void setClassroomType(String classroomType) {
		this.classroomType = classroomType;
	}
	/**
	 * 获取：教室类型
	 */
	public String getClassroomType() {
		return classroomType;
	}
	/**
	 * 设置：是否预约
	 */
	public void setIsAppointment(String isAppointment) {
		this.isAppointment = isAppointment;
	}
	/**
	 * 获取：是否预约
	 */
	public String getIsAppointment() {
		if(isAppointment==null){
			isAppointment="否";
		}
		return isAppointment;
	}

	/**
	 * 设置：审核状态
	 */
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	/**
	 * 获取：审核状态getApproveStatus
	 */
	public String getApproveStatus() {
		if(approveStatus==null){
			approveStatus="已保存";
		}
		return approveStatus;
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
	public String getCreateBy() {
		if(createBy==null){
			 SysUserEntity user = (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
			 if(user!=null){
				 String userName = user.getUsername();
				 createBy=userName;
			 }
		}
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	
}
