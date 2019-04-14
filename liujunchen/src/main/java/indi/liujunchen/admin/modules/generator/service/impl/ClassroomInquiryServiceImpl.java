package indi.liujunchen.admin.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import indi.liujunchen.admin.modules.generator.dao.ClassroomInquiryDao;
import indi.liujunchen.admin.modules.generator.entity.ClassroomInquiryEntity;
import indi.liujunchen.admin.modules.generator.entity.LeavingMessageEntity;
import indi.liujunchen.admin.modules.generator.service.ClassroomInquiryService;



@Service("classroomInquiryService")
public class ClassroomInquiryServiceImpl implements ClassroomInquiryService {
	@Autowired
	private ClassroomInquiryDao classroomInquiryDao;
	
	@Override
	public ClassroomInquiryEntity queryObject(String id){
		return classroomInquiryDao.queryObject(id);
	}
	
	@Override
	public List<ClassroomInquiryEntity> queryList(Map<String, Object> map){
		return classroomInquiryDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return classroomInquiryDao.queryTotal(map);
	}
	
	@Override
	public void save(ClassroomInquiryEntity classroomInquiry){
		classroomInquiryDao.save(classroomInquiry);
	}
	
	@Override
	public void update(ClassroomInquiryEntity classroomInquiry){
		classroomInquiryDao.update(classroomInquiry);
	}
	
	@Override
	public void delete(String id){
		classroomInquiryDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		classroomInquiryDao.deleteBatch(ids);
	}

	@Override
	public void appointment(ClassroomInquiryEntity classroomInquiry) {
		// TODO Auto-generated method stub
		classroomInquiryDao.appointment(classroomInquiry);
	}

	@Override
	public List<ClassroomInquiryEntity> querySelf(String userName) {
		// TODO Auto-generated method stub
		return classroomInquiryDao.querySelf(userName);
	}

	@Override
	public int queryTotalSelf(String userName) {
		// TODO Auto-generated method stub
		return classroomInquiryDao.queryTotalSelf(userName);
	}

	@Override
	public void agree(ClassroomInquiryEntity classroomInquiry) {
		// TODO Auto-generated method stub
		classroomInquiryDao.agree(classroomInquiry);
	}

	@Override
	public void refuse(ClassroomInquiryEntity classroomInquiry) {
		// TODO Auto-generated method stub
		classroomInquiryDao.refuse(classroomInquiry);
	}

	@Override
	public List<ClassroomInquiryEntity> queryselfLectrue(String userName) {
		// TODO Auto-generated method stub
		return classroomInquiryDao.queryselfLectrue(userName);
	}

	@Override
	public int queryTotalselfLectrue(String userName) {
		// TODO Auto-generated method stub
		return classroomInquiryDao.queryTotalselfLectrue(userName);
	}
		
	
	
}
