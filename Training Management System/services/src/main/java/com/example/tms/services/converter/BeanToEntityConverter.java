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

public final class BeanToEntityConverter {

	private BeanToEntityConverter() {
		throw new AssertionError("Class contains static methods only. Create an instance do not need!");
	}

	public static UsersEntity createUsersEntity(UserBean bean) {
		UsersEntity result = new UsersEntity();

		if (bean.getIdUser() != null) {
			result.setId(bean.getIdUser());
		}
		if (bean.getLogin() != null) {
			result.setLogin(bean.getLogin());
		}
		if (bean.getPassword() != null) {
			result.setPassword(bean.getPassword());
		}
		if (bean.getRole() != null) {
			result.setRole(bean.getRole());
		}

		return result;
	}

	public static UserDataEntity createUserDataEntity(UserBean bean) {
		UserDataEntity result = new UserDataEntity();

		if (bean.getIdUser() != null) {
			result.setId(bean.getIdUser());
		}
		if (bean.getLastName() != null) {
			result.setLastName(bean.getLastName());
		}
		if (bean.getFirstName() != null) {
			result.setFirstName(bean.getFirstName());
		}
		if (bean.getMiddleName() != null) {
			result.setMiddleName(bean.getMiddleName());
		}

		return result;
	}

	public static CoursesListEntity createCoursesListEntity(CourseBean bean) {
		CoursesListEntity result = new CoursesListEntity();

		result.setId(bean.getIdCourse());
		result.setCourseName(bean.getCourseName());
		result.setDescription(bean.getDescription());
		result.setStatus(bean.getStatusCourse());

		return result;
	}

	public static CoursesListEntity createCoursesListEntity(Integer idCourse) {
		CoursesListEntity result = new CoursesListEntity();

		result.setId(idCourse);

		return result;
	}

	public static GroupsEntity createGroupEntity(GroupBean bean) {
		GroupsEntity result = new GroupsEntity();

		if (bean.getIdGroup() != null) {
			result.setId(bean.getIdGroup());
		}
		if (bean.getIdTeacher() != null) {
			result.setIdTeacher(bean.getIdTeacher());
		}
		if (bean.getIdCourse() != null) {
			result.setIdCourse(bean.getIdCourse());
		}
		if (bean.getStatusGroup() != null) {
			result.setStatusGroup(bean.getStatusGroup());
		}

		return result;
	}

	public static DataGroupsEntity createDataGroupsEntity(DataGroupBean bean) {
		DataGroupsEntity result = new DataGroupsEntity();

		result.setId(bean.getIdDataGroup());
		result.setIdGroup(bean.getIdGroup());
		result.setIdListener(bean.getIdListener());

		return result;
	}

}
