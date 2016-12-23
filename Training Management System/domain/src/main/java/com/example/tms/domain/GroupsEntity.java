package com.example.tms.domain;

public class GroupsEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Integer idTeacher;
	private Integer idCourse;
	private String statusGroup;

	public GroupsEntity() {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTeacher == null) ? 0 : idTeacher.hashCode());
		result = prime * result + ((idCourse == null) ? 0 : idCourse.hashCode());
		result = prime * result + ((statusGroup == null) ? 0 : statusGroup.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		GroupsEntity other = (GroupsEntity) obj;
		if (idTeacher == null) {
			if (other.idTeacher != null) {
				return false;
			}
		} else if (idTeacher != other.idTeacher) {
			return false;
		}

		if (idCourse == null) {
			if (other.idCourse != null) {
				return false;
			}
		} else if (idCourse != other.idCourse) {
			return false;
		}

		if (statusGroup == null) {
			if (other.statusGroup != null) {
				return false;
			}
		} else if (statusGroup != other.statusGroup) {
			return false;
		}

		return true;
	}

}
