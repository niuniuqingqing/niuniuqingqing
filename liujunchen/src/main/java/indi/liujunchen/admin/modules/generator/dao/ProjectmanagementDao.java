package indi.liujunchen.admin.modules.generator.dao;

import indi.liujunchen.admin.modules.generator.entity.ProjectmanagementEntity;
import indi.liujunchen.admin.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 检查项目管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-13 10:02:44
 */
@Mapper
public interface ProjectmanagementDao extends BaseDao<ProjectmanagementEntity> {
	
}
