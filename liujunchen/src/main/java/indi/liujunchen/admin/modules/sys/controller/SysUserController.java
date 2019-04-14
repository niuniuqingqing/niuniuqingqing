package indi.liujunchen.admin.modules.sys.controller;


import indi.liujunchen.admin.common.annotation.SysLog;
import indi.liujunchen.admin.modules.sys.shiro.ShiroUtils;
import indi.liujunchen.admin.modules.sys.entity.SysUserEntity;
import indi.liujunchen.admin.common.utils.PageUtils;
import indi.liujunchen.admin.common.utils.Query;
import indi.liujunchen.admin.common.utils.R;
import indi.liujunchen.admin.common.validator.Assert;
import indi.liujunchen.admin.common.validator.ValidatorUtils;
import indi.liujunchen.admin.common.validator.group.AddGroup;
import indi.liujunchen.admin.common.validator.group.UpdateGroup;
import indi.liujunchen.admin.modules.sys.service.SysUserRoleService;
import indi.liujunchen.admin.modules.sys.service.SysUserService;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<SysUserEntity> userList = sysUserService.queryList(query);
		int total = sysUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	@RequestMapping("/self")
	public R self(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
	     String userName = (String) params.get("username");
	        
	        SysUserEntity user = (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
	        if(user!=null){
	        	userName = user.getUsername();
	        }
		List<SysUserEntity> userList = sysUserService.querySelf(userName);
		int total = sysUserService.queryTotalSelf(userName);
		
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public R info(){
		return R.ok().put("user", getUser());
	}
	
	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@RequestMapping("/password")
	public R password(String password, String newPassword){
		Assert.isBlank(newPassword, "新密码不为能空");

		//原密码
		password = ShiroUtils.sha256(password, getUser().getSalt());
		//新密码
		newPassword = ShiroUtils.sha256(newPassword, getUser().getSalt());
				
		//更新密码
		int count = sysUserService.updatePassword(getUserId(), password, newPassword);
		if(count == 0){
			return R.error("原密码不正确");
		}
		
		return R.ok();
	}
	
	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	public R info(@PathVariable("userId") Long userId){
		SysUserEntity user = sysUserService.queryObject(userId);
		
		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);
		
		return R.ok().put("user", user);
	}
	
	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@RequestMapping("/save")
	@RequiresPermissions("sys:user:save")
	public R save(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, AddGroup.class);
		
		sysUserService.save(user);
		
		return R.ok();
	}
	
	/**
	 * 注册用户
	 */
	@SysLog("注册用户")
	@RequestMapping("/register")
	public R register(String username, String password){
		//ValidatorUtils.validateEntity(user, AddGroup.class);
		//sysUserService.register(user);
		SysUserEntity user = sysUserService.queryUserName(username);
		if(user==null){
			user=new SysUserEntity();
			user.setUsername(username);
			user.setPassword(password);
			String salt = RandomStringUtils.randomAlphanumeric(20);
			user.setSalt(salt);
			user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
			user.setDeptId(Long.valueOf(6));
			user.setStatus(1);
			user.setCreateTime(new Date());
			sysUserService.register(user);
			return R.ok();
		}
		return R.error(1,"用户名存在");
	}
	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@RequestMapping("/update")
	@RequiresPermissions("sys:user:update")
	public R update(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, UpdateGroup.class);

		sysUserService.update(user);
		
		return R.ok();
	}
	
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:user:delete")
	public R delete(@RequestBody Long[] userIds){
		if(ArrayUtils.contains(userIds, 1L)){
			return R.error("系统管理员不能删除");
		}
		
		if(ArrayUtils.contains(userIds, getUserId())){
			return R.error("当前用户不能删除");
		}
		
		sysUserService.deleteBatch(userIds);
		
		return R.ok();
	}
}
