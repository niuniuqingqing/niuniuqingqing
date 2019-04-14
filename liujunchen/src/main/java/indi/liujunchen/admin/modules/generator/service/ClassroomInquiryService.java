package indi.liujunchen.admin.modules.generator.service;

import indi.liujunchen.admin.modules.generator.entity.ClassroomInquiryEntity;
import indi.liujunchen.admin.modules.generator.entity.LeavingMessageEntity;

import java.util.List;
import java.util.Map;

/**
 * 教室查询
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-04 22:04:44
 */
public interface ClassroomInquiryService {
	
	ClassroomInquiryEntity queryObject(String id);
	
	List<ClassroomInquiryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ClassroomInquiryEntity classroomInquiry);
	
	void update(ClassroomInquiryEntity classroomInquiry);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	void appointment(ClassroomInquiryEntity classroomInquiry);

	List<ClassroomInquiryEntity> querySelf(String userName);

	int queryTotalSelf(String userName);

	void agree(ClassroomInquiryEntity classroomInquiry);

	void refuse(ClassroomInquiryEntity classroomInquiry);

	List<ClassroomInquiryEntity> queryselfLectrue(String userName);

	int queryTotalselfLectrue(String userName);
}
