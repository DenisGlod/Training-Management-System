package com.example.tms.dao;

import java.util.List;

import com.example.tms.dao.exception.DaoException;
import com.example.tms.domain.DataGroupsEntity;
import com.example.tms.domain.UserDataEntity;

public interface DataGroupsDAO {

	Boolean checkDuplicate(DataGroupsEntity entity) throws DaoException;

	List<DataGroupsEntity> loadAllDataGroups() throws DaoException;
	
	DataGroupsEntity loadDataGroupsById(Integer idDataGroup) throws DaoException;

	DataGroupsEntity loadDataGroupsByIdListener(UserDataEntity entity) throws DaoException;

	void addDataGroup(DataGroupsEntity entity) throws DaoException;

	void editDataGroup(DataGroupsEntity entity) throws DaoException;

	void deleteDataGroup(Integer idDataGroup) throws DaoException;

}
