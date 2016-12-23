package com.example.tms.services;

import java.util.List;

import com.example.tms.beans.UserBean;

public interface UsersService {

	UserBean authorization(UserBean bean);

	List<UserBean> loadAllUsers();
	
	List<UserBean> loadAllListener();

	List<UserBean> loadAllTeacher();

	UserBean loadUserDataById(Integer userId);

	UserBean addUser(UserBean bean);

	UserBean editUser(UserBean bean);

	void deleteUser(Integer id);

}
