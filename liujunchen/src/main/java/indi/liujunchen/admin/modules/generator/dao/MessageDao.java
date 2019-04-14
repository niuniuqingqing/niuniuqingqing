package indi.liujunchen.admin.modules.generator.dao;

import indi.liujunchen.admin.modules.generator.entity.MessageEntity;
import indi.liujunchen.admin.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 消息管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-06 08:48:09
 */
@Mapper
public interface MessageDao extends BaseDao<MessageEntity> {
	
}
