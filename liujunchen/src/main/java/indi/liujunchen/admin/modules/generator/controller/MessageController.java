package indi.liujunchen.admin.modules.generator.controller;

import indi.liujunchen.admin.common.utils.PageUtils;
import indi.liujunchen.admin.common.utils.Query;
import indi.liujunchen.admin.common.utils.R;
import indi.liujunchen.admin.modules.generator.entity.MessageEntity;
import indi.liujunchen.admin.modules.generator.service.MessageService;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 消息管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-06 08:48:09
 */
@RestController
@RequestMapping("message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<MessageEntity> messageList = messageService.queryList(query);
		int total = messageService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(messageList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		MessageEntity message = messageService.queryObject(id);
		
		return R.ok().put("message", message);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody MessageEntity message){
		messageService.save(message);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody MessageEntity message){
		messageService.update(message);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		messageService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
