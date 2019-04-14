package indi.liujunchen.admin.modules.generator.dao;

import java.util.HashMap;
import java.util.List;

import indi.liujunchen.admin.modules.generator.entity.AppointmentEntity;
import indi.liujunchen.admin.modules.generator.entity.DepartmentmanagementEntity;
import indi.liujunchen.admin.modules.generator.entity.ProjectmanagementEntity;
import indi.liujunchen.admin.modules.sys.dao.BaseDao;
import indi.liujunchen.admin.modules.sys.dao.SysUserDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 预约
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 11:08:12
 */
@Mapper
public interface AppointmentDao extends BaseDao<AppointmentEntity> {

	List<ProjectmanagementEntity> getProject(HashMap<String, Object> hashMap);

	List<DepartmentmanagementEntity> getDeptmentManagement(
			HashMap<String, Object> hashMap);

	List<SysUserDao> getDoctor(HashMap<String, Object> hashMap);
	
}
