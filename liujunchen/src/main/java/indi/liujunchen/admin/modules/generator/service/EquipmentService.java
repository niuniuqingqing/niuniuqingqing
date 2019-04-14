package indi.liujunchen.admin.modules.generator.service;

import indi.liujunchen.admin.modules.generator.entity.EquipmentEntity;

import java.util.List;
import java.util.Map;

/**
 * 设备管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-05 16:53:12
 */
public interface EquipmentService {
	
	EquipmentEntity queryObject(Integer id);
	
	List<EquipmentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EquipmentEntity equipment);
	
	void update(EquipmentEntity equipment);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void repair(EquipmentEntity equipment);

	void normaluse(EquipmentEntity equipment);

	List<EquipmentEntity> querySelf(String userName);

	int queryTotalSelf(String userName);
}
