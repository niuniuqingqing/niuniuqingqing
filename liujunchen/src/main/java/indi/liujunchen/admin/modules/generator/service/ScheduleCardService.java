package indi.liujunchen.admin.modules.generator.service;

import indi.liujunchen.admin.modules.generator.entity.ScheduleCardEntity;

import java.util.List;
import java.util.Map;

/**
 * 课程查询
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-04 22:04:44
 */
public interface ScheduleCardService {
	
	ScheduleCardEntity queryObject(String id);
	
	List<ScheduleCardEntity> queryList(Map<String, Object> map);

	
	List<ScheduleCardEntity> querySelf(Object self);
	
	
	int queryTotal(Map<String, Object> map);
	
	void save(ScheduleCardEntity scheduleCard);
	
	void update(ScheduleCardEntity scheduleCard);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	void appointment(String[] ids);
	int queryTotalSelf(Object self);

	List<ScheduleCardEntity> querySelfExa(String userName);

	int queryTotalSelfExa(String userName);

	List<ScheduleCardEntity> querySelfExaSubmit(String userName);

	int queryTotalSelfExaSubmit(String userName);

	void submit(ScheduleCardEntity scheduleCard);

	void agree(ScheduleCardEntity scheduleCard);

	void refuse(ScheduleCardEntity scheduleCard);

	List<ScheduleCardEntity> queryselfLectrue(String userName);

	int queryTotalselfLectrue(String userName);

	List<ScheduleCardEntity> querylectrueList(String userName);

	int queryTotallectrueList(String userName);

	
	
}
