package indi.liujunchen.admin.modules.generator.dao;

import java.util.List;

import indi.liujunchen.admin.modules.generator.entity.ClassroomInquiryEntity;
import indi.liujunchen.admin.modules.generator.entity.LeavingMessageEntity;
import indi.liujunchen.admin.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 教室查询
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-05-04 22:04:44
 */
@Mapper
public interface ClassroomInquiryDao extends BaseDao<ClassroomInquiryEntity> {

	void appointment(ClassroomInquiryEntity classroomInquiry);

	int queryTotalSelf(String userName);

	void agree(ClassroomInquiryEntity classroomInquiry);

	void refuse(ClassroomInquiryEntity classroomInquiry);

	List<ClassroomInquiryEntity> queryselfLectrue(String userName);

	int queryTotalselfLectrue(String userName);
	
}
