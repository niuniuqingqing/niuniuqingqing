package indi.liujunchen.admin.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import indi.liujunchen.admin.modules.generator.dao.LeavingMessageDao;
import indi.liujunchen.admin.modules.generator.entity.LeavingMessageEntity;
import indi.liujunchen.admin.modules.generator.entity.ScheduleCardEntity;
import indi.liujunchen.admin.modules.generator.service.LeavingMessageService;



@Service("leavingMessageService")
public class LeavingMessageServiceImpl implements LeavingMessageService {
	@Autowired
	private LeavingMessageDao leavingMessageDao;
	
	@Override
	public LeavingMessageEntity queryObject(Integer id){
		return leavingMessageDao.queryObject(id);
	}
	
	@Override
	public List<LeavingMessageEntity> queryList(Map<String, Object> map){
		return leavingMessageDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return leavingMessageDao.queryTotal(map);
	}
	
	@Override
	public void save(LeavingMessageEntity leavingMessage){
		leavingMessageDao.save(leavingMessage);
	}
	
	@Override
	public void update(LeavingMessageEntity leavingMessage){
		leavingMessageDao.update(leavingMessage);
	}
	
	@Override
	public void delete(Integer id){
		leavingMessageDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		leavingMessageDao.deleteBatch(ids);
	}

	@Override
	public List<LeavingMessageEntity> querySelf(String userName) {
		// TODO Auto-generated method stub
		return leavingMessageDao.querySelf(userName);
	}

	@Override
	public int queryTotalSelf(String userName) {
		// TODO Auto-generated method stub
		return leavingMessageDao.queryTotalSelf(userName);
	}
	
}
