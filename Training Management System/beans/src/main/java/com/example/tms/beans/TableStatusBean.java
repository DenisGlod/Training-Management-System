package com.example.tms.beans;

import java.io.Serializable;

public class TableStatusBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean usersTableStatus;
	private Boolean coursesTableStatus;
	private Boolean groupsTableStatus;
	private Boolean dataGroupsTableStatus;

	public TableStatusBean(Boolean usersTableStatus, Boolean coursesTableStatus, Boolean groupsTableStatus,
			Boolean dataGroupsTableStatus) {
		this.usersTableStatus = usersTableStatus;
		this.coursesTableStatus = coursesTableStatus;
		this.groupsTableStatus = groupsTableStatus;
		this.dataGroupsTableStatus = dataGroupsTableStatus;
	}

	public Boolean getUsersTableStatus() {
		return usersTableStatus;
	}

	public void setUsersTableStatus(Boolean usersTableStatus) {
		this.usersTableStatus = usersTableStatus;
	}

	public Boolean getCoursesTableStatus() {
		return coursesTableStatus;
	}

	public void setCoursesTableStatus(Boolean coursesTableStatus) {
		this.coursesTableStatus = coursesTableStatus;
	}

	public Boolean getGroupsTableStatus() {
		return groupsTableStatus;
	}

	public void setGroupsTableStatus(Boolean groupsTableStatus) {
		this.groupsTableStatus = groupsTableStatus;
	}

	public Boolean getDataGroupsTableStatus() {
		return dataGroupsTableStatus;
	}

	public void setDataGroupsTableStatus(Boolean dataGroupsTableStatus) {
		this.dataGroupsTableStatus = dataGroupsTableStatus;
	}

}
