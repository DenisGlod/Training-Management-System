package com.example.tms.services.factory;

import com.example.tms.services.CoursesService;
import com.example.tms.services.DataGroupsService;
import com.example.tms.services.GroupsService;
import com.example.tms.services.UsersService;

public abstract class ServiceFactory {

	public abstract UsersService getUserService();

	public abstract CoursesService getCoursesService();

	public abstract GroupsService getGroupsService();

	public abstract DataGroupsService getDataGroupsService();

	public static ServiceFactory getFactory() {
		return new ServiceFactoryImpl();
	}

}
