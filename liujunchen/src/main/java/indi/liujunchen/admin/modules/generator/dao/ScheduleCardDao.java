package indi.liujunchen.admin.modules.generator.dao;

import java.util.List;

import indi.liujunchen.admin.modules.generator.entity.ScheduleCardEntity;
import indi.liujunchen.admin.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 课程查询
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-04 22:04:44
 */
@Mapper
public interface ScheduleCardDao extends BaseDao<ScheduleCardEntity> {

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
