package indi.liujunchen.admin.modules.sys.service.impl;

import indi.liujunchen.admin.common.annotation.DataFilter;
import indi.liujunchen.admin.modules.sys.dao.SysRoleDao;
import indi.liujunchen.admin.modules.sys.entity.SysRoleEntity;
import indi.liujunchen.admin.modules.sys.service.SysRoleDeptService;
import indi.liujunchen.admin.modules.sys.service.SysRoleMenuService;
import indi.liujunchen.admin.modules.sys.service.SysRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 角色
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:45:12
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysRoleDeptService sysRoleDeptService;

	@Override
	public SysRoleEntity queryObject(Long roleId) {
		return sysRoleDao.queryObject(roleId);
	}

	@Override
	@DataFilter(tableAlias = "r", user = false)
	public List<SysRoleEntity> queryList(Map<String, Object> map) {
		return sysRoleDao.queryList(map);
	}

	@Override
	@DataFilter(tableAlias = "r", user = false)
	public int queryTotal(Map<String, Object> map) {
		return sysRoleDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(SysRoleEntity role) {
		role.setCreateTime(new Date());
		sysRoleDao.save(role);
		
		//保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

		//保存角色与部门关系
		sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
	}

	@Override
	@Transactional
	public void update(SysRoleEntity role) {
		sysRoleDao.update(role);
		
		//更新角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

		//保存角色与部门关系
		sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
	}

	@Override
	@Transactional
	public void deleteBatch(Long[] roleIds) {
		sysRoleDao.deleteBatch(roleIds);
	}

	@Override
	public SysRoleEntity querySelf(String username) {
		// TODO Auto-generated method stub
		return (SysRoleEntity) sysRoleDao.querySelf(username);
		
	}

	@Override
	public SysRoleEntity queryRoleSelf(String username) {
		// TODO Auto-generated method stub
		return (SysRoleEntity) sysRoleDao.queryRoleSelf(username);
	}

}
