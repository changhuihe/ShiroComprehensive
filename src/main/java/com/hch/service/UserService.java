package com.hch.service;

import java.util.List;
import java.util.Set;

import com.hch.entity.User;

public interface UserService {
	/**
	 * �����û�
	 * 
	 * @param user
	 */
	public User createUser(User user);

	public User updateUser(User user);

	public void deleteUser(Long userId);

	/**
	 * �޸�����
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword);

	User findOne(Long userId);

	List<User> findAll();

	/**
	 * �����û��������û�
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

	/**
	 * �����û����������ɫ
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findRoles(String username);

	/**
	 * �����û���������Ȩ��
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String username);

}
