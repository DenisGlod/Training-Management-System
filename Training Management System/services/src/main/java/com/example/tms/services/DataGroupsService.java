package com.example.tms.services;

import java.util.List;

import com.example.tms.beans.DataGroupBean;

public interface DataGroupsService {

	List<DataGroupBean> loadAllDataGroups();

	DataGroupBean loadDataGroupsById(Integer idDataGroup);

	DataGroupBean addDataGroup(DataGroupBean bean);

	DataGroupBean editDataGroup(DataGroupBean bean);

	void deleteDataGroup(Integer idDataGroup);

}
