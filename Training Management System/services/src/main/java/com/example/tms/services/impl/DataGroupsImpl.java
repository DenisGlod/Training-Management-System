package com.example.tms.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.tms.beans.DataGroupBean;
import com.example.tms.dao.factory.DAOFactory;
import com.example.tms.domain.CoursesListEntity;
import com.example.tms.domain.DataGroupsEntity;
import com.example.tms.domain.GroupsEntity;
import com.example.tms.domain.UserDataEntity;
import com.example.tms.services.DataGroupsService;
import com.example.tms.services.converter.BeanToEntityConverter;
import com.example.tms.services.converter.EntityToBeanConverter;

public class DataGroupsImpl implements DataGroupsService {

	@Override
	public List<DataGroupBean> loadAllDataGroups() {
		List<DataGroupBean> result = new ArrayList<>();

		List<DataGroupsEntity> dataGroups = DAOFactory.getFactory().getDataGroupsDAO().loadAllDataGroups();
		List<UserDataEntity> userData = DAOFactory.getFactory().getUserDataDAO().loadAllUserData();
		List<GroupsEntity> groups = DAOFactory.getFactory().getGroupsDAO().loadAllGroups();
		List<CoursesListEntity> coursesList = DAOFactory.getFactory().getCoursesListDAO().loadAllCourses();

		DataGroupBean bean = null;
		for (DataGroupsEntity dataGroup : dataGroups) {
			bean = new DataGroupBean();
			bean.setIdDataGroup(dataGroup.getId());
			bean.setIdGroup(dataGroup.getIdGroup());
			for (UserDataEntity user : userData) {
				if (user.getId() == dataGroup.getIdListener()) {
					bean.setListenerName(user.getFullName());
					break;
				}
			}
			for (GroupsEntity group : groups) {
				if (group.getId() == dataGroup.getIdGroup()) {
					for (UserDataEntity user : userData) {
						if (group.getIdTeacher() == user.getId()) {
							bean.setTeacherName(user.getFullName());
							break;
						}
					}
					for (CoursesListEntity courseList : coursesList) {
						if (group.getIdCourse() == courseList.getId()) {
							bean.setCourseName(courseList.getCourseName());
							break;
						}
					}
				}
			}
			result.add(bean);
		}
		return result;
	}

	@Override
	public DataGroupBean loadDataGroupsById(Integer idDataGroup) {
		DataGroupsEntity loadDataGroupsById = DAOFactory.getFactory().getDataGroupsDAO().loadDataGroupsById(idDataGroup);
		DataGroupBean result = EntityToBeanConverter.createDataGroupBean(loadDataGroupsById);
		return result;
	}

	@Override
	public DataGroupBean addDataGroup(DataGroupBean bean) {
		DataGroupsEntity entity = BeanToEntityConverter.createDataGroupsEntity(bean);
		DAOFactory.getFactory().getDataGroupsDAO().addDataGroup(entity);
		bean.setErrorStatus(false);
		bean.setErrorMessage("Information! The listener is successfully added to group.");
		return bean;
	}

	@Override
	public DataGroupBean editDataGroup(DataGroupBean bean) {
		DataGroupsEntity entity = BeanToEntityConverter.createDataGroupsEntity(bean);
		DAOFactory.getFactory().getDataGroupsDAO().editDataGroup(entity);
		bean.setErrorStatus(false);
		bean.setErrorMessage("Information! Group updated successfully.");		
		return bean;
	}

	@Override
	public void deleteDataGroup(Integer idDataGroup) {
		DAOFactory.getFactory().getDataGroupsDAO().deleteDataGroup(idDataGroup);
	}

}
