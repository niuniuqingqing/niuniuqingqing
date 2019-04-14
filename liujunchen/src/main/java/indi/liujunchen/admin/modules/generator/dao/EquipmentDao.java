package indi.liujunchen.admin.modules.generator.dao;

import indi.liujunchen.admin.modules.generator.entity.EquipmentEntity;
import indi.liujunchen.admin.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 设备管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-05 16:53:12
 */
@Mapper
public interface EquipmentDao extends BaseDao<EquipmentEntity> {

	void repair(EquipmentEntity equipment);

	void normaluse(EquipmentEntity equipment);

	int queryTotalSelf(String userName);
	
}
