package indi.liujunchen.admin.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import indi.liujunchen.admin.modules.generator.dao.AppointmentDao;
import indi.liujunchen.admin.modules.generator.entity.AppointmentEntity;
import indi.liujunchen.admin.modules.generator.entity.DepartmentmanagementEntity;
import indi.liujunchen.admin.modules.generator.entity.ProjectmanagementEntity;
import indi.liujunchen.admin.modules.generator.service.AppointmentService;
import indi.liujunchen.admin.modules.sys.dao.SysUserDao;



@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public AppointmentEntity queryObject(Integer id){
		return appointmentDao.queryObject(id);
	}
	
	@Override
	public List<AppointmentEntity> queryList(Map<String, Object> map){
		return appointmentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appointmentDao.queryTotal(map);
	}
	
	@Override
	public void save(AppointmentEntity appointment){
		appointmentDao.save(appointment);
	}
	
	@Override
	public void update(AppointmentEntity appointment){
		appointmentDao.update(appointment);
	}
	
	@Override
	public void delete(Integer id){
		appointmentDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		appointmentDao.deleteBatch(ids);
	}

	@Override
	public List<ProjectmanagementEntity> getProject(
			HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return appointmentDao.getProject(hashMap);
	}

	@Override
	public List<DepartmentmanagementEntity> getDeptmentManagement(
			HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return appointmentDao.getDeptmentManagement(hashMap);
	}

	@Override
	public List<SysUserDao> getDoctor(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return appointmentDao.getDoctor(hashMap);
	}
	
}
