package com.example.tms.domain;

public class DataGroupsEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Integer idGroup;
	private Integer idListener;

	public DataGroupsEntity() {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGroup == null) ? 0 : idGroup.hashCode());
		result = prime * result + ((idListener == null) ? 0 : idListener.hashCode());
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

		DataGroupsEntity other = (DataGroupsEntity) obj;
		if (idGroup == null) {
			if (other.idGroup != null) {
				return false;
			}
		} else if (idGroup != other.idGroup) {
			return false;
		}

		if (idListener == null) {
			if (other.idListener != null) {
				return false;
			}
		} else if (idListener != other.idListener) {
			return false;
		}

		return true;
	}

}
