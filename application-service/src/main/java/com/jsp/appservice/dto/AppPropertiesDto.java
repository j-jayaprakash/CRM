package com.jsp.appservice.dto;

import java.io.Serializable;

public class AppPropertiesDto  implements Serializable{

	private String moduleName;
	
	private String propertykey;
	
	private String propertyValue;
	
	private String userName;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getPropertykey() {
		return propertykey;
	}

	public void setPropertykey(String propertykey) {
		this.propertykey = propertykey;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
