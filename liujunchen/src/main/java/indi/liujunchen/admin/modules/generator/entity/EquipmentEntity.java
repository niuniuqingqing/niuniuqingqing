package indi.liujunchen.admin.modules.generator.entity;

import indi.liujunchen.admin.modules.sys.entity.SysUserEntity;

import java.io.Serializable;
import java.util.Date;

import org.apache.shiro.SecurityUtils;



/**
 * 设备管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-05 16:53:12
 */
public class EquipmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//设备名称
	private String equipmentName;
	//设备所在地址
	private String equipmentAddress;
	//报修或正常使用
	private String problem;
	//创建人
	private String createBy;

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
	 * 设置：设备名称
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	/**
	 * 获取：设备名称
	 */
	public String getEquipmentName() {
		return equipmentName;
	}
	/**
	 * 设置：设备所在地址
	 */
	public void setEquipmentAddress(String equipmentAddress) {
		this.equipmentAddress = equipmentAddress;
	}
	/**
	 * 获取：设备所在地址
	 */
	public String getEquipmentAddress() {
		return equipmentAddress;
	}
	/**
	 * 设置：报修或正常使用
	 */
	public void setProblem(String problem) {
		this.problem = problem;
	}
	/**
	 * 获取：报修或正常使用
	 */
	public String getProblem() {
		return problem;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
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
}
