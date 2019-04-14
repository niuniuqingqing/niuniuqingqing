package indi.liujunchen.admin.modules.generator.controller;

import indi.liujunchen.admin.common.utils.PageUtils;
import indi.liujunchen.admin.common.utils.Query;
import indi.liujunchen.admin.common.utils.R;
import indi.liujunchen.admin.modules.generator.entity.ClassroomInquiryEntity;
import indi.liujunchen.admin.modules.generator.entity.EquipmentEntity;
import indi.liujunchen.admin.modules.generator.service.EquipmentService;
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
 * 设备管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-05 16:53:12
 */
@RestController
@RequestMapping("equipment")
public class EquipmentController {
	@Autowired
	private EquipmentService equipmentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EquipmentEntity> equipmentList = equipmentService.queryList(query);
		int total = equipmentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(equipmentList, total, query.getLimit(), query.getPage());
		
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
        
		List<EquipmentEntity> scheduleCardList = equipmentService.querySelf(userName);
		int total = equipmentService.queryTotalSelf(userName);
		
		PageUtils pageUtil = new PageUtils(scheduleCardList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		EquipmentEntity equipment = equipmentService.queryObject(id);
		
		return R.ok().put("equipment", equipment);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody EquipmentEntity equipment){
		equipmentService.save(equipment);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody EquipmentEntity equipment){
		equipmentService.update(equipment);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		equipmentService.deleteBatch(ids);
		
		return R.ok();
	}
	
	
	@RequestMapping("/repair")
	public R agree(@RequestBody EquipmentEntity equipment){
		equipmentService.repair(equipment);
		
		return R.ok();
	}
	
	
	@RequestMapping("/normaluse")
	public R normaluse(@RequestBody EquipmentEntity equipment){
		equipmentService.normaluse(equipment);
		return R.ok();
	}
	
	
	
}
