package com.example.tms.dao;

import java.util.List;

import com.example.tms.dao.exception.DaoException;
import com.example.tms.domain.UsersEntity;

public interface UsersDAO {

	List<UsersEntity> loadAllUsers() throws DaoException;

	UsersEntity loadUserById(Integer userId) throws DaoException;

	Boolean checkDuplicateLogin(UsersEntity entity) throws DaoException;

	UsersEntity verificationLoginAndPassword(UsersEntity entity) throws DaoException;

	UsersEntity addUser(UsersEntity entity) throws DaoException;

	void editUser(UsersEntity entity) throws DaoException;

	void deleteUser(Integer userId) throws DaoException;

}
