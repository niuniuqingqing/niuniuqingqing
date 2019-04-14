package indi.liujunchen.admin.modules.generator.entity;

import indi.liujunchen.admin.modules.sys.entity.SysUserEntity;

import java.io.Serializable;
import java.util.Date;

import org.apache.shiro.SecurityUtils;



/**
 * 留言管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-05 16:53:12
 */
/**
 * @author junchen
 *
 */
public class LeavingMessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//内容
	private String content;
	//时间
	private String shijian;
	//创建人
	private String createBy;

	private String reply;

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
		return shijian;
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
}
