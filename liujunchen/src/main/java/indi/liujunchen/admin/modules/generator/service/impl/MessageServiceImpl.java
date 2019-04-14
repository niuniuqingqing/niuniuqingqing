package indi.liujunchen.admin.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import indi.liujunchen.admin.modules.generator.dao.MessageDao;
import indi.liujunchen.admin.modules.generator.entity.MessageEntity;
import indi.liujunchen.admin.modules.generator.service.MessageService;



@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;
	
	@Override
	public MessageEntity queryObject(Integer id){
		return messageDao.queryObject(id);
	}
	
	@Override
	public List<MessageEntity> queryList(Map<String, Object> map){
		return messageDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return messageDao.queryTotal(map);
	}
	
	@Override
	public void save(MessageEntity message){
		messageDao.save(message);
	}
	
	@Override
	public void update(MessageEntity message){
		messageDao.update(message);
	}
	
	@Override
	public void delete(Integer id){
		messageDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		messageDao.deleteBatch(ids);
	}
	
}
