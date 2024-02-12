package com.jsp.appservice.constants;

public class ApplicationServiceConstants {

	public static final String CREATE_PROPERTIES="/createproperties"; 
	public static final String GET_PROPERTIES="/getproperties";
	public static final String UPDATE_APP_PROPERTIES="/updateappproperties/{altKey},{moduleName},{propertyKey},{propertyValue},{userName}";
	public static final String GET_PROPERTIES_BY_MODULE_NAME="/getpropertiesbymodulename";
	public static final String GET_PROPERTIES_BY_PROPERTY_KEY="/getpropertiesbypropertykey/{propertyKey}";
	public static final String REGISTER_SERVICE="/registerservice";
	public static final String GET_APP_SERVICE_BY_SERVICE_NAME="/getappservicebyservicename/{serviceName}";
	
	public static final String STATUS_CODE_SUCCESS ="200";
	public static final String STATUS_CODE_FAILURE ="500";
	public static final String STATUS_FAILURE ="FAILURE";
	public static final String STATUS_SUCCESS ="SUCCESS";

}
