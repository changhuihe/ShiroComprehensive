package com.hch.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.StringUtils;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id; // ���
	private String role; // ��ɫ��ʶ �������ж�ʹ��,��"admin"
	private String description; // ��ɫ����,UI������ʾʹ��
	private List<Long> resourceIds; // ӵ�е���Դ
	private Boolean available = Boolean.FALSE; // �Ƿ����,��������ý��������Ӹ��û�

	public Role() {
	}

	public Role(String role, String description, Boolean available) {
		this.role = role;
		this.description = description;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Long> getResourceIds() {
		if (resourceIds == null) {
			resourceIds = new ArrayList<Long>();
		}
		return resourceIds;
	}

	public void setResourceIds(List<Long> resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getResourceIdsStr() {
		if (CollectionUtils.isEmpty(resourceIds)) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for (Long resourceId : resourceIds) {
			s.append(resourceId);
			s.append(",");
		}
		return s.toString();
	}

	public void setResourceIdsStr(String resourceIdsStr) {
		if (StringUtils.isEmpty(resourceIdsStr)) {
			return;
		}
		String[] resourceIdStrs = resourceIdsStr.split(",");
		for (String resourceIdStr : resourceIdStrs) {
			if (StringUtils.isEmpty(resourceIdStr)) {
				continue;
			}
			getResourceIds().add(Long.valueOf(resourceIdStr));
		}
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Role role = (Role) o;

		if (id != null ? !id.equals(role.id) : role.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Role{" + "id=" + id + ", role='" + role + '\'' + ", description='" + description + '\''
				+ ", resourceIds=" + resourceIds + ", available=" + available + '}';
	}
}