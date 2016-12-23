package com.example.tms.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataGroupBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idDataGroup;
	private Integer idGroup;
	private Integer idListener;

	private String listenerName;
	private String teacherName;
	private String courseName;

	private Boolean errorStatus;
	private List<String> errorMessage;

	public DataGroupBean() {
		super();
		errorMessage = new ArrayList<String>();
	}

	public Integer getIdDataGroup() {
		return idDataGroup;
	}

	public void setIdDataGroup(Integer idDataGroup) {
		this.idDataGroup = idDataGroup;
	}

	public Integer getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(Integer idGroup) {
		this.idGroup = idGroup;
	}

	public Integer getIdListener() {
		return idListener;
	}

	public void setIdListener(Integer idListener) {
		this.idListener = idListener;
	}

	public String getListenerName() {
		return listenerName;
	}

	public void setListenerName(String listenerName) {
		this.listenerName = listenerName;
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
