package com.example.tms.dao;

import java.util.List;

import com.example.tms.dao.exception.DaoException;
import com.example.tms.domain.UserDataEntity;
import com.example.tms.domain.UsersEntity;

public interface UserDataDAO {

	List<UserDataEntity> loadAllUserData() throws DaoException;
	
	UserDataEntity loadUserDataById(UsersEntity entity) throws DaoException;

	void addUserData(UserDataEntity entity) throws DaoException;

	void editUserData(UserDataEntity entity) throws DaoException;

}
