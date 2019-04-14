package indi.liujunchen.admin.modules.generator.controller;

import indi.liujunchen.admin.common.utils.PageUtils;
import indi.liujunchen.admin.common.utils.Query;
import indi.liujunchen.admin.common.utils.R;
import indi.liujunchen.admin.modules.generator.entity.LeavingMessageEntity;
import indi.liujunchen.admin.modules.generator.entity.ScheduleCardEntity;
import indi.liujunchen.admin.modules.generator.service.LeavingMessageService;
import indi.liujunchen.admin.modules.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 留言管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-05 16:53:12
 */
@RestController
@RequestMapping("leavingmessage")
public class LeavingMessageController {
	@Autowired
	private LeavingMessageService leavingMessageService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<LeavingMessageEntity> leavingMessageList = leavingMessageService.queryList(query);
		int total = leavingMessageService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(leavingMessageList, total, query.getLimit(), query.getPage());
		
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
		List<LeavingMessageEntity> scheduleCardList = leavingMessageService.querySelf(userName);
		int total = leavingMessageService.queryTotalSelf(userName);
		
		PageUtils pageUtil = new PageUtils(scheduleCardList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		LeavingMessageEntity leavingMessage = leavingMessageService.queryObject(id);
		
		return R.ok().put("leavingMessage", leavingMessage);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody LeavingMessageEntity leavingMessage){
		leavingMessageService.save(leavingMessage);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody LeavingMessageEntity leavingMessage){
		leavingMessageService.update(leavingMessage);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		leavingMessageService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
