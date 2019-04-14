package indi.liujunchen.admin.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import indi.liujunchen.admin.modules.generator.dao.AppointmentrelationshipDao;
import indi.liujunchen.admin.modules.generator.entity.AppointmentrelationshipEntity;
import indi.liujunchen.admin.modules.generator.service.AppointmentrelationshipService;



@Service("appointmentrelationshipService")
public class AppointmentrelationshipServiceImpl implements AppointmentrelationshipService {
	@Autowired
	private AppointmentrelationshipDao appointmentrelationshipDao;
	
	@Override
	public AppointmentrelationshipEntity queryObject(Integer id){
		return appointmentrelationshipDao.queryObject(id);
	}
	
	@Override
	public List<AppointmentrelationshipEntity> queryList(Map<String, Object> map){
		return appointmentrelationshipDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appointmentrelationshipDao.queryTotal(map);
	}
	
	@Override
	public void save(AppointmentrelationshipEntity appointmentrelationship){
		appointmentrelationshipDao.save(appointmentrelationship);
	}
	
	@Override
	public void update(AppointmentrelationshipEntity appointmentrelationship){
		appointmentrelationshipDao.update(appointmentrelationship);
	}
	
	@Override
	public void delete(Integer id){
		appointmentrelationshipDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		appointmentrelationshipDao.deleteBatch(ids);
	}
	
}
