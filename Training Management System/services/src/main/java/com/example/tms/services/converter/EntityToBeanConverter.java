package com.example.tms.services.converter;

import com.example.tms.beans.CourseBean;
import com.example.tms.beans.DataGroupBean;
import com.example.tms.beans.GroupBean;
import com.example.tms.beans.UserBean;
import com.example.tms.domain.CoursesListEntity;
import com.example.tms.domain.DataGroupsEntity;
import com.example.tms.domain.GroupsEntity;
import com.example.tms.domain.UserDataEntity;
import com.example.tms.domain.UsersEntity;

public final class EntityToBeanConverter {

	private EntityToBeanConverter() {
		throw new AssertionError("Class contains static methods only. Create an instance do not need!");
	}

	public static UserBean createUserBean(UsersEntity usersEntity, UserDataEntity userDataEntity) {
		UserBean result = new UserBean();

		result.setIdUser(usersEntity.getId());
		result.setLogin(usersEntity.getLogin());
		result.setPassword(usersEntity.getPassword());
		result.setRole(usersEntity.getRole());
		result.setLastName(userDataEntity.getLastName());
		result.setFirstName(userDataEntity.getFirstName());
		result.setMiddleName(userDataEntity.getMiddleName());

		return result;
	}

	public static UserBean createUserBean(UsersEntity usersEntity) {
		UserBean result = new UserBean();

		if (usersEntity.getId() != null) {
			result.setIdUser(usersEntity.getId());
		}
		if (usersEntity.getLogin() != null) {
			result.setLogin(usersEntity.getLogin());
		}
		if (usersEntity.getPassword() != null) {
			result.setPassword(usersEntity.getPassword());
		}
		if (usersEntity.getRole() != null) {
			result.setRole(usersEntity.getRole());
		}

		return result;
	}

	public static CourseBean createCoursesBean(CoursesListEntity course) {
		CourseBean result = new CourseBean();

		result.setIdCourse(course.getId());
		result.setCourseName(course.getCourseName());
		result.setDescription(course.getDescription());
		result.setStatusCourse(course.getStatus());

		return result;
	}

	public static GroupBean createGroupBean(GroupsEntity groupEntity) {
		GroupBean result = new GroupBean();

		result.setIdGroup(groupEntity.getId());
		result.setIdTeacher(groupEntity.getIdTeacher());
		result.setIdCourse(groupEntity.getIdCourse());
		result.setStatusGroup(groupEntity.getStatusGroup());

		return result;
	}

	public static DataGroupBean createDataGroupBean(DataGroupsEntity dataDataGroupEntity) {
		DataGroupBean result = new DataGroupBean();

		result.setIdDataGroup(dataDataGroupEntity.getId());
		result.setIdGroup(dataDataGroupEntity.getIdGroup());
		result.setIdListener(dataDataGroupEntity.getIdListener());

		return result;
	}

}
