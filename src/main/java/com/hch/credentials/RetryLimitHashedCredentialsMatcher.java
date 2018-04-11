package com.hch.credentials;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

/*
 * �������Դ�������
 * HashedCredentialsMatcher�ṩ�˶�AuthenticationTokenƾ֤����ɢ�е�֧�֣�Ȼ����AuthenticationInfo�е����ݽ��жԱ�
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	private Cache<String, AtomicInteger> passwordRetryCache;

	/*
	 * CacheManager�����������ά��Cacheʵ������������
	 */
	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		// ��ȡָ���Ļ���,passwordRetryCacheΪehcache.xml�ļ������õĵ�¼��¼����
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	/*
	 * token���û��ύ�������֤����;info:�洢�����ݿ�������������ƥ�������
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String username = (String) token.getPrincipal();// ��ȡ���
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);// �ڻ��������ӵ�¼����
		}
		// incrementAndGet��ԭ�ӵķ�ʽ����ǰֵ+1
		if (retryCount.incrementAndGet() > 5) {
			throw new ExcessiveAttemptsException();
		}
		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			passwordRetryCache.remove(username);// ɾ����ָ�������Ӧ�Ļ�����Ŀ
		}
		return matches;
	}
}
