package indi.liujunchen.admin.modules.generator.service;

import indi.liujunchen.admin.modules.generator.entity.MessageEntity;

import java.util.List;
import java.util.Map;

/**
 * 消息管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-06 08:48:09
 */
public interface MessageService {
	
	MessageEntity queryObject(Integer id);
	
	List<MessageEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MessageEntity message);
	
	void update(MessageEntity message);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
