package com.example.tms.dao.mysql.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.tms.domain.CoursesListEntity;
import com.example.tms.domain.DataGroupsEntity;
import com.example.tms.domain.GroupsEntity;
import com.example.tms.domain.UserDataEntity;
import com.example.tms.domain.UsersEntity;

public final class ResultSetConverter {

	private ResultSetConverter() {
		throw new AssertionError("Class contains static methods only. Create an instance do not need!");
	}

	public static UsersEntity createUserEntity(ResultSet resultSet) throws SQLException {
		UsersEntity userEntity = new UsersEntity();

		userEntity.setId(resultSet.getInt("id_user"));
		userEntity.setLogin(resultSet.getString("login"));
		userEntity.setPassword(resultSet.getString("password"));
		userEntity.setRole(resultSet.getString("role"));

		return userEntity;
	}

	public static UserDataEntity createUserDataEntity(ResultSet resultSet) throws SQLException {
		UserDataEntity userDataEntity = new UserDataEntity();

		userDataEntity.setId(resultSet.getInt("id_user_data"));
		userDataEntity.setLastName(resultSet.getString("last_name"));
		userDataEntity.setFirstName(resultSet.getString("first_name"));
		userDataEntity.setMiddleName(resultSet.getString("middle_name"));

		return userDataEntity;
	}

	public static CoursesListEntity createCoursesListEntity(ResultSet resultSet) throws SQLException {
		CoursesListEntity coursesListEntity = new CoursesListEntity();

		coursesListEntity.setId(resultSet.getInt("id_course"));
		coursesListEntity.setCourseName(resultSet.getString("course_name"));
		coursesListEntity.setDescription(resultSet.getString("description"));
		coursesListEntity.setStatus(resultSet.getString("status_course"));

		return coursesListEntity;
	}

	public static GroupsEntity createGroupsEntity(ResultSet resultSet) throws SQLException {
		GroupsEntity groupsEntity = new GroupsEntity();

		groupsEntity.setId(resultSet.getInt("id_group"));
		groupsEntity.setIdTeacher(resultSet.getInt("id_teacher"));
		groupsEntity.setIdCourse(resultSet.getInt("id_course"));
		groupsEntity.setStatusGroup(resultSet.getString("status_group"));

		return groupsEntity;
	}

	public static DataGroupsEntity createDataGroupsEntity(ResultSet resultSet) throws SQLException {
		DataGroupsEntity dataGroupsEntity = new DataGroupsEntity();

		dataGroupsEntity.setId(resultSet.getInt("id_data_group"));
		dataGroupsEntity.setIdGroup(resultSet.getInt("id_group"));
		dataGroupsEntity.setIdListener(resultSet.getInt("id_listener"));

		return dataGroupsEntity;
	}

}
