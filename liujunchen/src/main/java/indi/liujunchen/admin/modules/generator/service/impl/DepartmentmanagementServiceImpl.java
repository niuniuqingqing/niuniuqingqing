package indi.liujunchen.admin.modules.generator.service.impl;

import indi.liujunchen.admin.modules.generator.dao.DepartmentmanagementDao;
import indi.liujunchen.admin.modules.generator.entity.DepartmentmanagementEntity;
import indi.liujunchen.admin.modules.generator.service.DepartmentmanagementService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("departmentmanagementService")
public class DepartmentmanagementServiceImpl implements DepartmentmanagementService {
	@Autowired
	private DepartmentmanagementDao departmentmanagementDao;
	
	@Override
	public DepartmentmanagementEntity queryObject(String id){
		return departmentmanagementDao.queryObject(id);
	}
	
	@Override
	public List<DepartmentmanagementEntity> queryList(Map<String, Object> map){
		return departmentmanagementDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return departmentmanagementDao.queryTotal(map);
	}
	
	@Override
	public void save(DepartmentmanagementEntity departmentmanagement){
		departmentmanagementDao.save(departmentmanagement);
	}
	
	@Override
	public void update(DepartmentmanagementEntity departmentmanagement){
		departmentmanagementDao.update(departmentmanagement);
	}
	
	@Override
	public void delete(String id){
		departmentmanagementDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		departmentmanagementDao.deleteBatch(ids);
	}
	
}
