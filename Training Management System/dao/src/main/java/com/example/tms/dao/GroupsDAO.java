package com.example.tms.dao;

import java.util.List;

import com.example.tms.dao.exception.DaoException;
import com.example.tms.domain.GroupsEntity;

public interface GroupsDAO {

	List<GroupsEntity> loadAllGroups() throws DaoException;

	List<GroupsEntity> loadGroupByIdTeacher(Integer idTeacher) throws DaoException;

	GroupsEntity loadGroupById(Integer idGroup) throws DaoException;

	void addGroup(GroupsEntity entity) throws DaoException;

	void editGroup(GroupsEntity entity) throws DaoException;

	void deleteGroup(Integer groupId) throws DaoException;

}
