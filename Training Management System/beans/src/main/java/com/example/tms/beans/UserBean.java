package com.example.tms.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUser;
	private String login;
	private String password;
	private String role;
	private String lastName;
	private String firstName;
	private String middleName;

	private Boolean errorStatus;
	private List<String> errorMessage;

	public UserBean() {
		super();
		errorMessage = new ArrayList<>();
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public String getFullName() {
		return String.join(" ", lastName, firstName, middleName);
	}

}
