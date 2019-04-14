package indi.liujunchen.admin.modules.generator.service.impl;

import indi.liujunchen.admin.modules.generator.dao.ProjectmanagementDao;
import indi.liujunchen.admin.modules.generator.entity.ProjectmanagementEntity;
import indi.liujunchen.admin.modules.generator.service.ProjectmanagementService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("projectmanagementService")
public class ProjectmanagementServiceImpl implements ProjectmanagementService {
	@Autowired
	private ProjectmanagementDao projectmanagementDao;
	
	@Override
	public ProjectmanagementEntity queryObject(Integer id){
		return projectmanagementDao.queryObject(id);
	}
	
	@Override
	public List<ProjectmanagementEntity> queryList(Map<String, Object> map){
		return projectmanagementDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return projectmanagementDao.queryTotal(map);
	}
	
	@Override
	public void save(ProjectmanagementEntity projectmanagement){
		projectmanagementDao.save(projectmanagement);
	}
	
	@Override
	public void update(ProjectmanagementEntity projectmanagement){
		projectmanagementDao.update(projectmanagement);
	}
	
	@Override
	public void delete(Integer id){
		projectmanagementDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		projectmanagementDao.deleteBatch(ids);
	}
	
}
