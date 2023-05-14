package com.testyan.rmgyan.GenericUtils;

public interface EndPoints
{
	/**
	 * @author HARI HARAN
	 * These 2 End Points are for adding and getting Projects
	 */
	public String addProject_EP = "/addProject";
	public String getALLProject_EP = "/projects";

	/**
	 * @author HARI HARAN
	 * These 2 End Points are for adding and getting employees
	 */
	public String addEmployee_EP = "/employees";
	public String getAllEmployees_EP = "/employees";

	/**
	 * @author HARI HARAN
	 * This End Point is for authentication
	 */
	public String authenticate_EP = "/login";



}
