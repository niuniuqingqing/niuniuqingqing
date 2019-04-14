package indi.liujunchen.admin.modules.generator.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import indi.liujunchen.admin.common.utils.PageUtils;
import indi.liujunchen.admin.common.utils.Query;
import indi.liujunchen.admin.common.utils.R;
import indi.liujunchen.admin.modules.generator.entity.AppointmentEntity;
import indi.liujunchen.admin.modules.generator.entity.DepartmentmanagementEntity;
import indi.liujunchen.admin.modules.generator.entity.ProjectmanagementEntity;
import indi.liujunchen.admin.modules.generator.service.AppointmentService;
import indi.liujunchen.admin.modules.sys.dao.SysUserDao;


/**
 * 预约
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 11:08:12
 */
@RestController
@RequestMapping("appointment")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("appointment:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AppointmentEntity> appointmentList = appointmentService.queryList(query);
		int total = appointmentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(appointmentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("appointment:info")
	public R info(@PathVariable("id") Integer id){
		AppointmentEntity appointment = appointmentService.queryObject(id);
		
		return R.ok().put("appointment", appointment);
	}
	
	//查询检查项目
	@RequestMapping("/getProject")
	public List<ProjectmanagementEntity> getProject(@RequestParam Map<String, Object> params){
		List<ProjectmanagementEntity> deptList = appointmentService.getProject(new HashMap<String, Object>());
		return deptList;
	}
	
	
	//查询科室
	@RequestMapping("/getDeptmentManagement")
	public List<DepartmentmanagementEntity> getDeptmentManagement(@RequestParam Map<String, Object> params){
		List<DepartmentmanagementEntity> deptList = appointmentService.getDeptmentManagement(new HashMap<String, Object>());
		return deptList;
	}
	
	//查询医务人员
	@RequestMapping("/getDoctor")
	public List<SysUserDao> getDoctor(@RequestParam Map<String, Object> params){
		List<SysUserDao> deptList = appointmentService.getDoctor(new HashMap<String, Object>());
		return deptList;
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("appointment:save")
	public R save(@RequestBody AppointmentEntity appointment){
		appointmentService.save(appointment);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("appointment:update")
	public R update(@RequestBody AppointmentEntity appointment){
		appointmentService.update(appointment);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("appointment:delete")
	public R delete(@RequestBody Integer[] ids){
		appointmentService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
