package indi.liujunchen.admin.modules.generator.service;

import indi.liujunchen.admin.modules.generator.entity.ProjectmanagementEntity;

import java.util.List;
import java.util.Map;

/**
 * 检查项目管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 10:02:44
 */
public interface ProjectmanagementService {
	
	ProjectmanagementEntity queryObject(Integer id);
	
	List<ProjectmanagementEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ProjectmanagementEntity projectmanagement);
	
	void update(ProjectmanagementEntity projectmanagement);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
