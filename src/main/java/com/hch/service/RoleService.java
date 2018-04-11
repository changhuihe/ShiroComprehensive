package com.hch.service;

import java.util.List;
import java.util.Set;

import com.hch.entity.Role;

public interface RoleService {
	public Role createRole(Role role);

	public Role updateRole(Role role);

	public void deleteRole(Long roleId);

	public Role findOne(Long roleId);

	public List<Role> findAll();

	/**
	 * ���ݽ�ɫ��ŵõ���ɫ��ʶ���б�
	 * 
	 * @param roleIds
	 * @return
	 */
	Set<String> findRoles(Long... roleIds);

	/**
	 * ���ݽ�ɫ��ŵõ�Ȩ���ַ����б�
	 * 
	 * @param roleIds
	 * @return
	 */
	Set<String> findPermissions(Long[] roleIds);

}
