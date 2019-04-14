package indi.liujunchen.admin.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import indi.liujunchen.admin.modules.generator.dao.ScheduleCardDao;
import indi.liujunchen.admin.modules.generator.entity.ScheduleCardEntity;
import indi.liujunchen.admin.modules.generator.service.ScheduleCardService;



@Service("scheduleCardService")
public class ScheduleCardServiceImpl implements ScheduleCardService {
	@Autowired
	private ScheduleCardDao scheduleCardDao;
	
	@Override
	public ScheduleCardEntity queryObject(String id){
		return scheduleCardDao.queryObject(id);
	}
	
	@Override
	public List<ScheduleCardEntity> queryList(Map<String, Object> map){
		return scheduleCardDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return scheduleCardDao.queryTotal(map);
	}
	
	@Override
	public void save(ScheduleCardEntity scheduleCard){
		scheduleCardDao.save(scheduleCard);
	}
	
	@Override
	public void update(ScheduleCardEntity scheduleCard){
		scheduleCardDao.update(scheduleCard);
	}
	
	@Override
	public void delete(String id){
		scheduleCardDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		scheduleCardDao.deleteBatch(ids);
	}

	@Override
	public void appointment(String[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ScheduleCardEntity> querySelf(Object self) {
		// TODO Auto-generated method stub
		return scheduleCardDao.querySelf(self);
	}

	@Override
	public int queryTotalSelf(Object self) {
		// TODO Auto-generated method stub
		return scheduleCardDao.queryTotalSelf(self);
	}

	@Override
	public List<ScheduleCardEntity> querySelfExa(String userName) {
		// TODO Auto-generated method stub
		return scheduleCardDao.querySelfExa(userName);
	}

	@Override
	public int queryTotalSelfExa(String userName) {
		// TODO Auto-generated method stub
		return scheduleCardDao.queryTotalSelfExa(userName);
	}

	@Override
	public List<ScheduleCardEntity> querySelfExaSubmit(String userName) {
		// TODO Auto-generated method stub
		return scheduleCardDao.querySelfExaSubmit(userName);
	}

	@Override
	public int queryTotalSelfExaSubmit(String userName) {
		// TODO Auto-generated method stub
		return scheduleCardDao.queryTotalSelfExaSubmit(userName);
	}

	@Override
	public void submit(ScheduleCardEntity scheduleCard) {
		// TODO Auto-generated method stub
		scheduleCardDao.submit(scheduleCard);
	}

	@Override
	public void agree(ScheduleCardEntity scheduleCard) {
		// TODO Auto-generated method stub
		scheduleCardDao.agree(scheduleCard);
	}

	@Override
	public void refuse(ScheduleCardEntity scheduleCard) {
		// TODO Auto-generated method stub
		scheduleCardDao.refuse(scheduleCard);
	}

	@Override
	public List<ScheduleCardEntity> queryselfLectrue(String userName) {
		// TODO Auto-generated method stub
		return scheduleCardDao.queryselfLectrue(userName);
	}

	@Override
	public int queryTotalselfLectrue(String userName) {
		// TODO Auto-generated method stub
		return scheduleCardDao.queryTotalselfLectrue(userName);
	}

	@Override
	public List<ScheduleCardEntity> querylectrueList(String userName) {
		// TODO Auto-generated method stub
		return scheduleCardDao.querylectrueList(userName);
	}

	@Override
	public int queryTotallectrueList(String userName) {
		// TODO Auto-generated method stub
		return scheduleCardDao.queryTotallectrueList(userName);
	}
	
}
