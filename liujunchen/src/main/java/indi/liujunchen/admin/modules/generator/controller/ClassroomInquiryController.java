package indi.liujunchen.admin.modules.generator.controller;

import indi.liujunchen.admin.common.utils.PageUtils;
import indi.liujunchen.admin.common.utils.Query;
import indi.liujunchen.admin.common.utils.R;
import indi.liujunchen.admin.modules.generator.entity.ClassroomInquiryEntity;
import indi.liujunchen.admin.modules.generator.entity.LeavingMessageEntity;
import indi.liujunchen.admin.modules.generator.entity.ScheduleCardEntity;
import indi.liujunchen.admin.modules.generator.service.ClassroomInquiryService;
import indi.liujunchen.admin.modules.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 教室查询
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-04 22:04:44
 */
@RestController
@RequestMapping("classroominquiry")
public class ClassroomInquiryController {
	@Autowired
	private ClassroomInquiryService classroomInquiryService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ClassroomInquiryEntity> classroomInquiryList = classroomInquiryService.queryList(query);
		int total = classroomInquiryService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(classroomInquiryList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	//localhost:8080/renren-security/classroominquiry/self?page=1&limit=10&order=asc&sidx=&username=admin
	@RequestMapping(value="/self")
	public R self(@RequestParam Map<String, Object> params){
		//查询列表数据 {_search=false, nd=1525644720554, limit=10, page=1, sidx=, order=asc, _=1525644720442}
        Query query = new Query(params);
        String userName = (String) params.get("username");
        
        SysUserEntity user = (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
        if(user!=null){
        	userName = user.getUsername();
        }
		List<ClassroomInquiryEntity> scheduleCardList = classroomInquiryService.querySelf(userName);
		int total = classroomInquiryService.queryTotalSelf(userName);
		
		PageUtils pageUtil = new PageUtils(scheduleCardList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	
	
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") String id){
		ClassroomInquiryEntity classroomInquiry = classroomInquiryService.queryObject(id);
		
		return R.ok().put("classroomInquiry", classroomInquiry);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ClassroomInquiryEntity classroomInquiry){
		classroomInquiryService.save(classroomInquiry);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ClassroomInquiryEntity classroomInquiry){
		classroomInquiryService.update(classroomInquiry);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody String[] ids){
		classroomInquiryService.deleteBatch(ids);
		
		return R.ok();
	}
	
	
	@RequestMapping("/appointment")
	public R appointment(@RequestBody ClassroomInquiryEntity classroomInquiry){
		classroomInquiryService.appointment(classroomInquiry);
		return R.ok();
	}
	

	@RequestMapping("/agree")
	public R agree(@RequestBody ClassroomInquiryEntity classroomInquiry){
		classroomInquiryService.agree(classroomInquiry);
		
		return R.ok();
	}
	
	
	@RequestMapping("/refuse")
	public R refuse(@RequestBody ClassroomInquiryEntity classroomInquiry){
		classroomInquiryService.refuse(classroomInquiry);
		return R.ok();
	}
	
}
