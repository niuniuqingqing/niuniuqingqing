package indi.liujunchen.admin.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import indi.liujunchen.admin.modules.generator.dao.EquipmentDao;
import indi.liujunchen.admin.modules.generator.entity.EquipmentEntity;
import indi.liujunchen.admin.modules.generator.service.EquipmentService;



@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	private EquipmentDao equipmentDao;
	
	@Override
	public EquipmentEntity queryObject(Integer id){
		return equipmentDao.queryObject(id);
	}
	
	@Override
	public List<EquipmentEntity> queryList(Map<String, Object> map){
		return equipmentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return equipmentDao.queryTotal(map);
	}
	
	@Override
	public void save(EquipmentEntity equipment){
		equipmentDao.save(equipment);
	}
	
	@Override
	public void update(EquipmentEntity equipment){
		equipmentDao.update(equipment);
	}
	
	@Override
	public void delete(Integer id){
		equipmentDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		equipmentDao.deleteBatch(ids);
	}

	@Override
	public void repair(EquipmentEntity equipment) {
		// TODO Auto-generated method stub
		equipmentDao.repair(equipment);
	}

	@Override
	public void normaluse(EquipmentEntity equipment) {
		// TODO Auto-generated method stub
		equipmentDao.normaluse(equipment);
	}

	@Override
	public List<EquipmentEntity> querySelf(String userName) {
		// TODO Auto-generated method stub
		return equipmentDao.querySelf(userName);
	}

	@Override
	public int queryTotalSelf(String userName) {
		// TODO Auto-generated method stub
		return equipmentDao.queryTotalSelf(userName);
	}
	
}
