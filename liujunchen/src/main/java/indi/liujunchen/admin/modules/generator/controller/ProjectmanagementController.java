package indi.liujunchen.admin.modules.generator.controller;

import indi.liujunchen.admin.common.utils.PageUtils;
import indi.liujunchen.admin.common.utils.Query;
import indi.liujunchen.admin.common.utils.R;
import indi.liujunchen.admin.modules.generator.entity.ProjectmanagementEntity;
import indi.liujunchen.admin.modules.generator.service.ProjectmanagementService;

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
 * 检查项目管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 10:02:44
 */
@RestController
@RequestMapping("projectmanagement")
public class ProjectmanagementController {
	@Autowired
	private ProjectmanagementService projectmanagementService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("projectmanagement:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ProjectmanagementEntity> projectmanagementList = projectmanagementService.queryList(query);
		int total = projectmanagementService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(projectmanagementList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("projectmanagement:info")
	public R info(@PathVariable("id") Integer id){
		ProjectmanagementEntity projectmanagement = projectmanagementService.queryObject(id);
		
		return R.ok().put("projectmanagement", projectmanagement);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("projectmanagement:save")
	public R save(@RequestBody ProjectmanagementEntity projectmanagement){
		projectmanagementService.save(projectmanagement);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("projectmanagement:update")
	public R update(@RequestBody ProjectmanagementEntity projectmanagement){
		projectmanagementService.update(projectmanagement);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("projectmanagement:delete")
	public R delete(@RequestBody Integer[] ids){
		projectmanagementService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
