package com.example.tms.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idCourse;
	private String courseName;
	private String description;
	private String statusCourse;

	private Boolean errorStatus;
	private List<String> errorMessage;

	public CourseBean() {
		super();
		errorMessage = new ArrayList<String>();
	}

	public Integer getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {
		this.idCourse = idCourse;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatusCourse() {
		return statusCourse;
	}

	public void setStatusCourse(String statusCourse) {
		this.statusCourse = statusCourse;
	}

	public Boolean getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(Boolean errorStatus) {
		this.errorStatus = errorStatus;
	}

	public List<String> getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		errorMessage.add(message);
	}

}
