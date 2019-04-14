package indi.liujunchen.admin.modules.generator.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 预约
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 11:08:12
 */
public class AppointmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//预约时间
	private String shijian;
	//创建人
	private String createby;

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
	 * 设置：预约时间
	 */
	public void setShijian(String shijian) {
		this.shijian = shijian;
	}
	/**
	 * 获取：预约时间
	 */
	public String getShijian() {
		return shijian;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateby() {
		return createby;
	}
}
