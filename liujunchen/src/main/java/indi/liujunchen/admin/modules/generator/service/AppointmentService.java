package indi.liujunchen.admin.modules.generator.service;

import indi.liujunchen.admin.modules.generator.entity.AppointmentEntity;
import indi.liujunchen.admin.modules.generator.entity.DepartmentmanagementEntity;
import indi.liujunchen.admin.modules.generator.entity.ProjectmanagementEntity;
import indi.liujunchen.admin.modules.sys.dao.SysUserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预约
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 11:08:12
 */
public interface AppointmentService {
	
	AppointmentEntity queryObject(Integer id);
	
	List<AppointmentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppointmentEntity appointment);
	
	void update(AppointmentEntity appointment);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	List<ProjectmanagementEntity> getProject(HashMap<String, Object> hashMap);

	List<DepartmentmanagementEntity> getDeptmentManagement(
			HashMap<String, Object> hashMap);

	List<SysUserDao> getDoctor(HashMap<String, Object> hashMap);
}
