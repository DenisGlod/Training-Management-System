package com.example.tms.domain;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	public AbstractEntity() {
		// NOOP
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		throw new RuntimeException("This method can not be used because Abstract Entity object type");
	}

	@Override
	public boolean equals(Object obj) {
		throw new RuntimeException("This method can not be used because Abstract Entity object type");
	}
}
