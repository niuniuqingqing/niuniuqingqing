package indi.liujunchen.admin.modules.generator.service;

import indi.liujunchen.admin.modules.generator.entity.DepartmentmanagementEntity;

import java.util.List;
import java.util.Map;

/**
 * 科室管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 10:02:43
 */
public interface DepartmentmanagementService {
	
	DepartmentmanagementEntity queryObject(String id);
	
	List<DepartmentmanagementEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DepartmentmanagementEntity departmentmanagement);
	
	void update(DepartmentmanagementEntity departmentmanagement);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
