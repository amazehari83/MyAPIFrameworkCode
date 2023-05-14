package com.projectpojolib;
/**
 * 
 * @author M.Harihara Manikandan
 *
 */
public class ProjectLib {
       String createdBy;
	   String projectName;
	   String status;
	   int teamSize;
	   
	   /*
	 Steps to create constructors using Fields.
	 	right click --> source --> Generate Constructors using Fields
	 	
	 Steps to generate Getters and Setters for all Fields
	 	right click --> source --> Generate Getters and Setters
	  */
	public ProjectLib(String createdBy, String projectName, String status, int teamSize) 
	{
		//super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
		
		
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	   
	   
	}



