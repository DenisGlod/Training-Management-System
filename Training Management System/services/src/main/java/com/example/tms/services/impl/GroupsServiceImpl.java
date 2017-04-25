package com.example.tms.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.tms.beans.GroupBean;
import com.example.tms.dao.CoursesListDAO;
import com.example.tms.dao.GroupsDAO;
import com.example.tms.dao.UserDataDAO;
import com.example.tms.dao.factory.DAOFactory;
import com.example.tms.domain.CoursesListEntity;
import com.example.tms.domain.GroupsEntity;
import com.example.tms.domain.UserDataEntity;
import com.example.tms.services.GroupsService;
import com.example.tms.services.converter.BeanToEntityConverter;
import com.example.tms.services.converter.EntityToBeanConverter;

public class GroupsServiceImpl implements GroupsService {

	@Override
	public List<GroupBean> loadAllGroups() {
		List<GroupBean> reslt = new ArrayList<>();

		UserDataDAO userDataDAO = DAOFactory.getFactory().getUserDataDAO();
		CoursesListDAO coursesListDAO = DAOFactory.getFactory().getCoursesListDAO();
		GroupsDAO groupsDAO = DAOFactory.getFactory().getGroupsDAO();

		List<UserDataEntity> loadAllUserData = userDataDAO.loadAllUserData();
		List<CoursesListEntity> loadAllCourses = coursesListDAO.loadAllCourses();
		List<GroupsEntity> loadAllGroups = groupsDAO.loadAllGroups();

		GroupBean resultBean = null;
		for (GroupsEntity groupsEntity : loadAllGroups) {
			resultBean = new GroupBean();
			resultBean.setIdGroup(groupsEntity.getId());
			resultBean.setStatusGroup(groupsEntity.getStatusGroup());
			for (CoursesListEntity coursesListEntity : loadAllCourses) {
				if (coursesListEntity.getId() == groupsEntity.getIdCourse()) {
					resultBean.setIdCourse(coursesListEntity.getId());
					resultBean.setCourseName(coursesListEntity.getCourseName());
					break;
				}
			}
			for (UserDataEntity userDataEntity : loadAllUserData) {
				if (userDataEntity.getId() == groupsEntity.getIdTeacher()) {
					resultBean.setTeacherName(String.join(" ", userDataEntity.getLastName(), userDataEntity.getFirstName(), userDataEntity.getMiddleName()));
					break;
				}
			}
			reslt.add(resultBean);
		}

		return reslt;
	}
	
	@Override
	public List<GroupBean> loadAllGroupsNotClose() {
		List<GroupBean> result = new ArrayList<>();
		List<GroupBean> loadAllGroups = loadAllGroups();
		for (GroupBean groupBean : loadAllGroups) {
			if (!groupBean.getStatusGroup().equals("close")) {
				result.add(groupBean);
			}
		}
		return result;
	}

	@Override
	public GroupBean loadGroupById(Integer idGroup) {
		GroupsDAO groupsDAO = DAOFactory.getFactory().getGroupsDAO();
		GroupsEntity loadGroupById = groupsDAO.loadGroupById(idGroup);
		GroupBean result = EntityToBeanConverter.createGroupBean(loadGroupById);
		return result;
	}

	@Override
	public GroupBean addGroup(GroupBean bean) {
		GroupsDAO groupsDAO = DAOFactory.getFactory().getGroupsDAO();
		groupsDAO.addGroup(BeanToEntityConverter.createGroupEntity(bean));
		bean.setErrorStatus(false);
		bean.setErrorMessage("Information! Group successfully added.");
		return bean;
	}

	@Override
	public GroupBean editGroup(GroupBean bean) {
		GroupsDAO groupsDAO = DAOFactory.getFactory().getGroupsDAO();
		groupsDAO.editGroup(BeanToEntityConverter.createGroupEntity(bean));
		bean.setErrorStatus(false);
		bean.setErrorMessage("Information! Group successfully added.");
		return bean;
	}

	@Override
	public void deleteGroup(Integer groupId) {
		GroupsDAO groupsDAO = DAOFactory.getFactory().getGroupsDAO();
		groupsDAO.deleteGroup(groupId);
	}

}
