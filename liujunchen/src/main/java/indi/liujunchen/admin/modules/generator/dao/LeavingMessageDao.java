package indi.liujunchen.admin.modules.generator.dao;

import indi.liujunchen.admin.modules.generator.entity.LeavingMessageEntity;
import indi.liujunchen.admin.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 留言管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-05 16:53:12
 */
@Mapper
public interface LeavingMessageDao extends BaseDao<LeavingMessageEntity> {

	int queryTotalSelf(String userName);
	
}
