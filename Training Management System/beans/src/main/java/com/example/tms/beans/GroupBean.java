package com.example.tms.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idGroup;
	private Integer idTeacher;
	private Integer idCourse;
	private String statusGroup;

	private String teacherName;
	private String courseName;

	private Boolean errorStatus;
	private List<String> errorMessage;

	public GroupBean() {
		super();
		errorMessage = new ArrayList<String>();
	}

	public Integer getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(Integer idGroup) {
		this.idGroup = idGroup;
	}

	public Integer getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(Integer idTeacher) {
		this.idTeacher = idTeacher;
	}

	public Integer getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {
		this.idCourse = idCourse;
	}

	public String getStatusGroup() {
		return statusGroup;
	}

	public void setStatusGroup(String statusGroup) {
		this.statusGroup = statusGroup;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
