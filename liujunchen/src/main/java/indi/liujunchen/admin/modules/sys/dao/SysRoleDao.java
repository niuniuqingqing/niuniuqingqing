package indi.liujunchen.admin.modules.sys.dao;

import indi.liujunchen.admin.modules.sys.entity.SysRoleEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:33:33
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

	SysRoleEntity queryRoleSelf(String username);
	

}
