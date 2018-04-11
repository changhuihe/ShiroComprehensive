package com.hch.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hch.dao.UserDao;
import com.hch.entity.User;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordHelper passwordHelper;
	@Autowired
	private RoleService roleService;

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	public User createUser(User user) {
		// ��������
		passwordHelper.encryptPassword(user);
		return userDao.createUser(user);
	}

	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	public void deleteUser(Long userId) {
		userDao.deleteUser(userId);
	}

	/**
	 * �޸�����
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword) {
		User user = userDao.findOne(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userDao.updateUser(user);
	}

	public User findOne(Long userId) {
		return userDao.findOne(userId);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	/**
	 * �����û��������û�
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	/**
	 * �����û����������ɫ
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findRoles(String username) {
		User user = findByUsername(username);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));
	}

	/**
	 * �����û���������Ȩ��
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String username) {
		User user = findByUsername(username);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		return roleService.findPermissions(user.getRoleIds().toArray(new Long[0]));
	}

}