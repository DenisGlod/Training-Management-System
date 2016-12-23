package com.example.tms.dao.factory;

import com.example.tms.dao.CoursesListDAO;
import com.example.tms.dao.DataGroupsDAO;
import com.example.tms.dao.GroupsDAO;
import com.example.tms.dao.UserDataDAO;
import com.example.tms.dao.UsersDAO;
import com.example.tms.dao.mysql.MySqlCoursesListDAO;
import com.example.tms.dao.mysql.MySqlDataGroupsDAO;
import com.example.tms.dao.mysql.MySqlGroupsDAO;
import com.example.tms.dao.mysql.MySqlUserDataDAO;
import com.example.tms.dao.mysql.MySqlUsersDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsersDAO getUsersDAO() {
		return new MySqlUsersDAO();
	}

	@Override
	public UserDataDAO getUserDataDAO() {
		return new MySqlUserDataDAO();
	}

	@Override
	public CoursesListDAO getCoursesListDAO() {
		return new MySqlCoursesListDAO();
	}

	@Override
	public GroupsDAO getGroupsDAO() {
		return new MySqlGroupsDAO();
	}

	@Override
	public DataGroupsDAO getDataGroupsDAO() {
		return new MySqlDataGroupsDAO();
	}
}
