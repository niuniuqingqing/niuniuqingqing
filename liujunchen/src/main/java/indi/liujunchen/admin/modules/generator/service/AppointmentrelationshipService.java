package indi.liujunchen.admin.modules.generator.service;

import indi.liujunchen.admin.modules.generator.entity.AppointmentrelationshipEntity;

import java.util.List;
import java.util.Map;

/**
 * 关系表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 11:08:12
 */
public interface AppointmentrelationshipService {
	
	AppointmentrelationshipEntity queryObject(Integer id);
	
	List<AppointmentrelationshipEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppointmentrelationshipEntity appointmentrelationship);
	
	void update(AppointmentrelationshipEntity appointmentrelationship);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
