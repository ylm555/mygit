package com.icss.ssm.entity;

import java.util.List;

/**
 * 权限实体类
 * @author Administrator
 *
 */
public class Rights {

	private String id;//权限编号
	private String rightsname;//权限名称
	private String parent_id;//权限父编号
	private String url;//请求地址
	private List<Rights> subRightsList;//子权限列表
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRightsname() {
		return rightsname;
	}
	public void setRightsname(String rightsname) {
		this.rightsname = rightsname;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Rights> getSubRightsList() {
		return subRightsList;
	}
	public void setSubRightsList(List<Rights> subRightsList) {
		this.subRightsList = subRightsList;
	}
	
	
	
}
