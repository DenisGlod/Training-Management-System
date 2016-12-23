package com.example.tms.services;

import java.util.List;

import com.example.tms.beans.GroupBean;

public interface GroupsService {

	List<GroupBean> loadAllGroups();
	
	List<GroupBean> loadAllGroupsNotClose();

	GroupBean loadGroupById(Integer idGroup);

	GroupBean addGroup(GroupBean bean);

	GroupBean editGroup(GroupBean bean);

	void deleteGroup(Integer groupId);

}
