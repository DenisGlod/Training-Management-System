package com.example.tms.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.example.tms.beans.UserBean;
import com.example.tms.dao.UserDataDAO;
import com.example.tms.dao.UsersDAO;
import com.example.tms.dao.factory.DAOFactory;
import com.example.tms.domain.UserDataEntity;
import com.example.tms.domain.UsersEntity;
import com.example.tms.services.UsersService;
import com.example.tms.services.converter.BeanToEntityConverter;
import com.example.tms.services.converter.EntityToBeanConverter;

public class UsersServiceImpl implements UsersService {

	@Override
	public UserBean authorization(UserBean bean) {
		UsersDAO usersDAO = DAOFactory.getFactory().getUsersDAO();
		UsersEntity verification = usersDAO.verificationLoginAndPassword(BeanToEntityConverter.createUsersEntity(bean));
		UserBean result = new UserBean();
		if (verification == null) {
			result.setErrorStatus(true);
		} else {
			UserDataDAO userDataDAO = DAOFactory.getFactory().getUserDataDAO();
			UserDataEntity loadUserDataById = userDataDAO.loadUserDataById(verification);
			result = EntityToBeanConverter.createUserBean(verification, loadUserDataById);
			result.setErrorStatus(false);
		}
		return result;
	}

	@Override
	public List<UserBean> loadAllUsers() {
		List<UserBean> result = new ArrayList<UserBean>();
		UsersDAO usersDAO = DAOFactory.getFactory().getUsersDAO();
		UserDataDAO userDataDAO = DAOFactory.getFactory().getUserDataDAO();
		List<UsersEntity> loadAllUsers = usersDAO.loadAllUsers();
		List<UserDataEntity> loadAllUserData = userDataDAO.loadAllUserData();
		for (UsersEntity usersEntity : loadAllUsers) {
			for (UserDataEntity userDataEntity : loadAllUserData) {
				if (usersEntity.getId() == userDataEntity.getId()) {
					result.add(EntityToBeanConverter.createUserBean(usersEntity, userDataEntity));
					break;
				}
			}
		}
		return result;
	}

	@Override
	public List<UserBean> loadAllListener() {
		List<UserBean> result = new ArrayList<UserBean>();
		List<UsersEntity> usersList = DAOFactory.getFactory().getUsersDAO().loadAllUsers();
		List<UserDataEntity> dataUsers = DAOFactory.getFactory().getUserDataDAO().loadAllUserData();
		for (UsersEntity user : usersList) {
			UserBean bean = new UserBean();
			for (UserDataEntity userData : dataUsers) {
				if (user.getId() == userData.getId() && StringUtils.equals(user.getRole(), "listener")) {
					bean.setIdUser(userData.getId());
					bean.setLastName(userData.getLastName());
					bean.setFirstName(userData.getFirstName());
					bean.setMiddleName(userData.getMiddleName());
					result.add(bean);
					break;
				}
			}
		}
		return result;
	}

	@Override
	public List<UserBean> loadAllTeacher() {
		List<UserBean> result = new ArrayList<UserBean>();
		UsersDAO usersDAO = DAOFactory.getFactory().getUsersDAO();
		UserDataDAO userDataDAO = DAOFactory.getFactory().getUserDataDAO();
		List<UsersEntity> loadAllUsers = usersDAO.loadAllUsers();
		List<UserDataEntity> loadAllUserData = userDataDAO.loadAllUserData();
		for (UsersEntity usersEntity : loadAllUsers) {
			for (UserDataEntity userDataEntity : loadAllUserData) {
				if (usersEntity.getId() == userDataEntity.getId() && usersEntity.getRole().equals("teacher")) {
					result.add(EntityToBeanConverter.createUserBean(usersEntity, userDataEntity));
					break;
				}
			}
		}
		return result;
	}

	@Override
	public UserBean loadUserDataById(Integer userId) {
		UsersDAO usersDAO = DAOFactory.getFactory().getUsersDAO();
		UserDataDAO userDataDAO = DAOFactory.getFactory().getUserDataDAO();
		UsersEntity userEntity = usersDAO.loadUserById(userId);
		UserDataEntity userDataEntity = userDataDAO.loadUserDataById(userEntity);
		UserBean createUserBean = EntityToBeanConverter.createUserBean(userEntity, userDataEntity);
		return createUserBean;
	}

	@Override
	public UserBean addUser(UserBean bean) {
		UsersDAO usersDAO = DAOFactory.getFactory().getUsersDAO();
		UserDataDAO userDataDAO = DAOFactory.getFactory().getUserDataDAO();
		UsersEntity usersEntity = BeanToEntityConverter.createUsersEntity(bean);
		if (usersDAO.checkDuplicateLogin(usersEntity)) {
			bean.setErrorStatus(true);
			bean.setErrorMessage("Error! This login already exists.");
		} else {
			if (usersEntity.getRole() == null) {
				usersEntity.setRole("listener");
			}
			bean.setErrorStatus(false);
			bean.setErrorMessage("Information! User successfully added.");
			usersEntity = usersDAO.addUser(usersEntity);
			bean.setIdUser(usersEntity.getId());
			userDataDAO.addUserData(BeanToEntityConverter.createUserDataEntity(bean));
		}
		return bean;
	}

	@Override
	public UserBean editUser(UserBean bean) {
		UserBean result = new UserBean();
		UsersDAO usersDAO = DAOFactory.getFactory().getUsersDAO();
		UserDataDAO userDataDAO = DAOFactory.getFactory().getUserDataDAO();
		UsersEntity usersEntity = BeanToEntityConverter.createUsersEntity(bean);
		usersDAO.editUser(usersEntity);
		userDataDAO.editUserData(BeanToEntityConverter.createUserDataEntity(bean));
		result.setErrorStatus(false);
		result.setErrorMessage("Information! User updated successfully.");
		return result;
	}

	@Override
	public void deleteUser(Integer id) {
		UsersDAO usersDAO = DAOFactory.getFactory().getUsersDAO();
		usersDAO.deleteUser(id);
	}

}
