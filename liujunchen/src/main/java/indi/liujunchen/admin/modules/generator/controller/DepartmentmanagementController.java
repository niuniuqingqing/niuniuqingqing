package indi.liujunchen.admin.modules.generator.controller;

import indi.liujunchen.admin.common.utils.PageUtils;
import indi.liujunchen.admin.common.utils.Query;
import indi.liujunchen.admin.common.utils.R;
import indi.liujunchen.admin.modules.generator.entity.DepartmentmanagementEntity;
import indi.liujunchen.admin.modules.generator.service.DepartmentmanagementService;

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
 * 科室管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 10:02:43
 */
@RestController
@RequestMapping("departmentmanagement")
public class DepartmentmanagementController {
	@Autowired
	private DepartmentmanagementService departmentmanagementService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("departmentmanagement:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DepartmentmanagementEntity> departmentmanagementList = departmentmanagementService.queryList(query);
		int total = departmentmanagementService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(departmentmanagementList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("departmentmanagement:info")
	public R info(@PathVariable("id") String id){
		DepartmentmanagementEntity departmentmanagement = departmentmanagementService.queryObject(id);
		
		return R.ok().put("departmentmanagement", departmentmanagement);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("departmentmanagement:save")
	public R save(@RequestBody DepartmentmanagementEntity departmentmanagement){
		departmentmanagementService.save(departmentmanagement);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("departmentmanagement:update")
	public R update(@RequestBody DepartmentmanagementEntity departmentmanagement){
		departmentmanagementService.update(departmentmanagement);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("departmentmanagement:delete")
	public R delete(@RequestBody String[] ids){
		departmentmanagementService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
