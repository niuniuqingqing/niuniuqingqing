package indi.liujunchen.admin.modules.generator.entity;

import indi.liujunchen.admin.modules.sys.entity.SysUserEntity;

import java.io.Serializable;
import java.util.Date;

import org.apache.shiro.SecurityUtils;



/**
 * 消息管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-06 08:48:09
 */
public class MessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//内容
	private String content;
	//时间
	private String shijian;
	//创建人
	private String createby;
	//阅读
	private String read;

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
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
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
		if(shijian==null){
			shijian = new Date().toString();
		}
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
		if(createby==null){
			 SysUserEntity user = (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
			 if(user!=null){
				 String userName = user.getUsername();
				 createby=userName;
			 }
		   
		}
		return createby;
	}
	/**
	 * 设置：阅读
	 */
	public void setRead(String read) {
		if(read==null){
			read="未读";
		}
		this.read = read;
	}
	/**
	 * 获取：阅读
	 */
	public String getRead() {
		return read;
	}
}
