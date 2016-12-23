package com.example.tms.dao.factory;

import com.example.tms.dao.CoursesListDAO;
import com.example.tms.dao.DataGroupsDAO;
import com.example.tms.dao.GroupsDAO;
import com.example.tms.dao.UserDataDAO;
import com.example.tms.dao.UsersDAO;
import com.example.tms.dao.exception.UnsupportedStoradgeTypeException;

public abstract class DAOFactory {

	public abstract UsersDAO getUsersDAO();

	public abstract UserDataDAO getUserDataDAO();

	public abstract CoursesListDAO getCoursesListDAO();

	public abstract GroupsDAO getGroupsDAO();
	
	public abstract DataGroupsDAO getDataGroupsDAO();

	public static DAOFactory getFactory() {
		return getFactory(StorageTypes.MySql);
	}

	public static DAOFactory getFactory(StorageTypes type) {
		switch (type) {
		case MySql:
			return new MySqlDAOFactory();
		default:
			throw new UnsupportedStoradgeTypeException();
		}
	}

}
