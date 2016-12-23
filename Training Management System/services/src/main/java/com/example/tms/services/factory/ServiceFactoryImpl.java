package com.example.tms.services.factory;

import com.example.tms.services.CoursesService;
import com.example.tms.services.DataGroupsService;
import com.example.tms.services.GroupsService;
import com.example.tms.services.UsersService;
import com.example.tms.services.impl.CoursesServiceImpl;
import com.example.tms.services.impl.DataGroupsImpl;
import com.example.tms.services.impl.GroupsServiceImpl;
import com.example.tms.services.impl.UsersServiceImpl;

public class ServiceFactoryImpl extends ServiceFactory {

	@Override
	public UsersService getUserService() {
		return new UsersServiceImpl();
	}

	@Override
	public CoursesService getCoursesService() {
		return new CoursesServiceImpl();
	}

	@Override
	public GroupsService getGroupsService() {
		return new GroupsServiceImpl();
	}

	@Override
	public DataGroupsService getDataGroupsService() {
		return new DataGroupsImpl();
	}

}
