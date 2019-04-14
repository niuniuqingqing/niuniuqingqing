package indi.liujunchen.admin.modules.generator.controller;

import indi.liujunchen.admin.common.utils.PageUtils;
import indi.liujunchen.admin.common.utils.Query;
import indi.liujunchen.admin.common.utils.R;
import indi.liujunchen.admin.modules.generator.entity.ClassroomInquiryEntity;
import indi.liujunchen.admin.modules.generator.entity.ScheduleCardEntity;
import indi.liujunchen.admin.modules.generator.service.ScheduleCardService;
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
 * 课程查询
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-04 22:04:44
 */
@RestController
@RequestMapping("schedulecard")
public class ScheduleCardController {
	@Autowired
	private ScheduleCardService scheduleCardService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        
		List<ScheduleCardEntity> scheduleCardList = scheduleCardService.queryList(query);
		int total = scheduleCardService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(scheduleCardList, total, query.getLimit(), query.getPage());
		
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
        
		List<ScheduleCardEntity> scheduleCardList = scheduleCardService.querySelf(userName);
		int total = scheduleCardService.queryTotalSelf(userName);
		
		PageUtils pageUtil = new PageUtils(scheduleCardList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	@RequestMapping("/selfExa")
	public R selfExa(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        
        
        String userName = (String) params.get("username");
         
         SysUserEntity user = (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
         if(user!=null){
         	
         	userName = user.getUsername();
         }
		List<ScheduleCardEntity> scheduleCardList = scheduleCardService.querySelfExa(userName);
		int total = scheduleCardService.queryTotalSelfExa(userName);
		
		PageUtils pageUtil = new PageUtils(scheduleCardList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	@RequestMapping("/selfLectrue")
	public R selfLectrue(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        
        String userName = (String) params.get("username");
        
        SysUserEntity user = (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
        if(user!=null){
        	
        	userName = user.getUsername();
        }
		List<ScheduleCardEntity> scheduleCardList = scheduleCardService.queryselfLectrue(userName);
		int total = scheduleCardService.queryTotalselfLectrue(userName);
		
		PageUtils pageUtil = new PageUtils(scheduleCardList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	@RequestMapping("/selfExaSubmit")
	public R selfExaSubmmit(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        
        String userName = (String) params.get("username");
        
        SysUserEntity user = (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
        if(user!=null){
        	
        	userName = user.getUsername();
        }
        
		List<ScheduleCardEntity> scheduleCardList = scheduleCardService.querySelfExaSubmit(userName);
		int total = scheduleCardService.queryTotalSelfExaSubmit(userName);
		
		PageUtils pageUtil = new PageUtils(scheduleCardList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	@RequestMapping("/lectrueList")
	public R lectrueList(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        
        String userName = (String) params.get("username");
        
        SysUserEntity user = (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
        if(user!=null){
        	
        	userName = user.getUsername();
        }
        
		List<ScheduleCardEntity> scheduleCardList = scheduleCardService.querylectrueList(userName);
		int total = scheduleCardService.queryTotallectrueList(userName);
		
		PageUtils pageUtil = new PageUtils(scheduleCardList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("schedulecard:info")
	public R info(@PathVariable("id") String id){
		ScheduleCardEntity scheduleCard = scheduleCardService.queryObject(id);
		
		return R.ok().put("scheduleCard", scheduleCard);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ScheduleCardEntity scheduleCard){
		scheduleCardService.save(scheduleCard);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ScheduleCardEntity scheduleCard){
		scheduleCardService.update(scheduleCard);
		
		return R.ok();
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/submit")
	public R submit(@RequestBody ScheduleCardEntity scheduleCard){
		scheduleCardService.submit(scheduleCard);
		
		return R.ok();
	}
	

	@RequestMapping("/agree")
	public R agree(@RequestBody ScheduleCardEntity scheduleCard){
		scheduleCardService.agree(scheduleCard);
		
		return R.ok();
	}
	
	
	@RequestMapping("/refuse")
	public R refuse(@RequestBody ScheduleCardEntity scheduleCard){
		scheduleCardService.refuse(scheduleCard);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody String[] ids){
		scheduleCardService.deleteBatch(ids);
		
		return R.ok();
	}
	/**
	 * 预约
	 */
	@RequestMapping("/appointment")
	public R appointment(@RequestBody String[] ids){
		scheduleCardService.deleteBatch(ids);
		
		return R.ok();
	}
}
