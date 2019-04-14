package indi.liujunchen.admin.modules.generator.service;

import indi.liujunchen.admin.modules.generator.entity.LeavingMessageEntity;
import indi.liujunchen.admin.modules.generator.entity.ScheduleCardEntity;

import java.util.List;
import java.util.Map;

/**
 * 留言管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-05 16:53:12
 */
public interface LeavingMessageService {
	
	LeavingMessageEntity queryObject(Integer id);
	
	List<LeavingMessageEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(LeavingMessageEntity leavingMessage);
	
	void update(LeavingMessageEntity leavingMessage);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	List<LeavingMessageEntity> querySelf(String userName);

	int queryTotalSelf(String userName);
}
