package indi.liujunchen.admin.modules.generator.controller;

import indi.liujunchen.admin.common.utils.PageUtils;
import indi.liujunchen.admin.common.utils.Query;
import indi.liujunchen.admin.common.utils.R;
import indi.liujunchen.admin.modules.generator.entity.AppointmentrelationshipEntity;
import indi.liujunchen.admin.modules.generator.service.AppointmentrelationshipService;

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
 * 关系表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 11:08:12
 */
@RestController
@RequestMapping("appointmentrelationship")
public class AppointmentrelationshipController {
	@Autowired
	private AppointmentrelationshipService appointmentrelationshipService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("appointmentrelationship:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AppointmentrelationshipEntity> appointmentrelationshipList = appointmentrelationshipService.queryList(query);
		int total = appointmentrelationshipService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(appointmentrelationshipList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("appointmentrelationship:info")
	public R info(@PathVariable("id") Integer id){
		AppointmentrelationshipEntity appointmentrelationship = appointmentrelationshipService.queryObject(id);
		
		return R.ok().put("appointmentrelationship", appointmentrelationship);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("appointmentrelationship:save")
	public R save(@RequestBody AppointmentrelationshipEntity appointmentrelationship){
		appointmentrelationshipService.save(appointmentrelationship);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("appointmentrelationship:update")
	public R update(@RequestBody AppointmentrelationshipEntity appointmentrelationship){
		appointmentrelationshipService.update(appointmentrelationship);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("appointmentrelationship:delete")
	public R delete(@RequestBody Integer[] ids){
		appointmentrelationshipService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
