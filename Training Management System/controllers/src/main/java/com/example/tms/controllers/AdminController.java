package com.example.tms.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.example.tms.beans.CourseBean;
import com.example.tms.beans.DataGroupBean;
import com.example.tms.beans.GroupBean;
import com.example.tms.beans.TableStatusBean;
import com.example.tms.beans.UserBean;
import com.example.tms.services.CoursesService;
import com.example.tms.services.DataGroupsService;
import com.example.tms.services.GroupsService;
import com.example.tms.services.UsersService;
import com.example.tms.services.factory.ServiceFactory;

@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final String LOG_OUT = "log out";
    private final String USERS_TABLE = "users table";
    private final String COURSES_TABLE = "courses table";
    private final String GROUPS_TABLE = "groups table";
    private final String DATA_GROUPS_TABLE = "data groups table";

    private final String ADD_USER = "add user";
    private final String ADD_COURSE = "add course";
    private final String ADD_GROUP = "add group";
    private final String ADD_DATA_GROUP = "add data group";

    private final String SAVE_USER = "save user";
    private final String SAVE_COURSE = "save course";
    private final String SAVE_GROUP = "save group";
    private final String SAVE_DATA_GROUP = "save data group";

    private final String UPDATE_USER = "update user";
    private final String UPDATE_COURSE = "update course";
    private final String UPDATE_GROUP = "update group";
    private final String UPDATE_DATA_GROUP = "update data group";

    private final String EDIT_USERS = "edit users";
    private final String EDIT_COURSES = "edit courses";
    private final String EDIT_GROUPS = "edit group";
    private final String EDIT_DATA_GROUP = "edit data group";

    private final String DELETE_USERS = "delete users";
    private final String DELETE_COURSES = "delete courses";
    private final String DELETE_GROUPS = "delete group";
    private final String DELETE_DATA_GROUP = "delete data group";

    private final String ERROR_MESSAGE = "Error! Some fields are not filled.";
    
    private final String TABLE_STATUS = "tableStatus";

    protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	Boolean firstInput = (Boolean) session.getAttribute("firstInput");
	String logOut = request.getParameter(LOG_OUT);
	String buttonUsersTable = request.getParameter(USERS_TABLE);
	String buttonCoursesTable = request.getParameter(COURSES_TABLE);
	String buttonGroupsTable = request.getParameter(GROUPS_TABLE);
	String buttonDataGroupsTable = request.getParameter(DATA_GROUPS_TABLE);

	String addUser = request.getParameter(ADD_USER);
	String addCourse = request.getParameter(ADD_COURSE);
	String addGroup = request.getParameter(ADD_GROUP);
	String addDataGroup = request.getParameter(ADD_DATA_GROUP);

	String saveUser = request.getParameter(SAVE_USER);
	String saveCourse = request.getParameter(SAVE_COURSE);
	String saveGroup = request.getParameter(SAVE_GROUP);
	String savedDataGoup = request.getParameter(SAVE_DATA_GROUP);

	String updateUser = request.getParameter(UPDATE_USER);
	String updateCourse = request.getParameter(UPDATE_COURSE);
	String updateGroup = request.getParameter(UPDATE_GROUP);
	String updateDataGroup = request.getParameter(UPDATE_DATA_GROUP);

	String editUsers = request.getParameter(EDIT_USERS);
	String editCourses = request.getParameter(EDIT_COURSES);
	String editGroups = request.getParameter(EDIT_GROUPS);
	String editDataGroups = request.getParameter(EDIT_DATA_GROUP);

	String deleteUsers = request.getParameter(DELETE_USERS);
	String deleteCourses = request.getParameter(DELETE_COURSES);
	String deleteGroup = request.getParameter(DELETE_GROUPS);
	String deleteDataGroups = request.getParameter(DELETE_DATA_GROUP);

	if (firstInput) {
	    session.setAttribute("firstInput", false);
	    actions(request, response, "default");
	} else {
	    if (StringUtils.isNoneBlank(logOut)) {
		actions(request, response, LOG_OUT);
	    }
	    if (StringUtils.isNoneBlank(buttonUsersTable)) {
		actions(request, response, USERS_TABLE);
	    }
	    if (StringUtils.isNoneBlank(buttonCoursesTable)) {
		actions(request, response, COURSES_TABLE);
	    }
	    if (StringUtils.isNoneBlank(buttonGroupsTable)) {
		actions(request, response, GROUPS_TABLE);
	    }
	    if (StringUtils.isNoneBlank(buttonDataGroupsTable)) {
		actions(request, response, DATA_GROUPS_TABLE);
	    }
	    if (StringUtils.isNoneBlank(addUser)) {
		actions(request, response, ADD_USER);
	    }
	    if (StringUtils.isNoneBlank(addCourse)) {
		actions(request, response, ADD_COURSE);
	    }
	    if (StringUtils.isNoneBlank(addGroup)) {
		actions(request, response, ADD_GROUP);
	    }
	    if (StringUtils.isNoneBlank(addDataGroup)) {
		actions(request, response, ADD_DATA_GROUP);
	    }
	    if (StringUtils.isNoneBlank(saveUser)) {
		actions(request, response, SAVE_USER);
	    }
	    if (StringUtils.isNoneBlank(saveCourse)) {
		actions(request, response, SAVE_COURSE);
	    }
	    if (StringUtils.isNoneBlank(saveGroup)) {
		actions(request, response, SAVE_GROUP);
	    }
	    if (StringUtils.isNoneBlank(savedDataGoup)) {
		actions(request, response, SAVE_DATA_GROUP);
	    }
	    if (StringUtils.isNoneBlank(updateUser)) {
		actions(request, response, UPDATE_USER, updateUser);
	    }
	    if (StringUtils.isNoneBlank(updateCourse)) {
		actions(request, response, UPDATE_COURSE, updateCourse);
	    }
	    if (StringUtils.isNoneBlank(updateGroup)) {
		actions(request, response, UPDATE_GROUP, updateGroup);
	    }
	    if (StringUtils.isNoneBlank(updateDataGroup)) {
		actions(request, response, UPDATE_DATA_GROUP, updateDataGroup);
	    }
	    if (StringUtils.isNoneBlank(editUsers)) {
		actions(request, response, EDIT_USERS, editUsers);
	    }
	    if (StringUtils.isNoneBlank(editCourses)) {
		actions(request, response, EDIT_COURSES, editCourses);
	    }
	    if (StringUtils.isNoneBlank(editGroups)) {
		actions(request, response, EDIT_GROUPS, editGroups);
	    }
	    if (StringUtils.isNoneBlank(editDataGroups)) {
		actions(request, response, EDIT_DATA_GROUP, editDataGroups);
	    }
	    if (StringUtils.isNoneBlank(deleteUsers)) {
		actions(request, response, DELETE_USERS, deleteUsers);
	    }
	    if (StringUtils.isNoneBlank(deleteCourses)) {
		actions(request, response, DELETE_COURSES, deleteCourses);
	    }
	    if (StringUtils.isNoneBlank(deleteGroup)) {
		actions(request, response, DELETE_GROUPS, deleteGroup);
	    }
	    if (StringUtils.isNoneBlank(deleteDataGroups)) {
		actions(request, response, DELETE_DATA_GROUP, deleteDataGroups);
	    }
	}
    }

    private void actions(HttpServletRequest request, HttpServletResponse response, String key) throws IOException {
	actions(request, response, key, null);
    }

    private void actions(HttpServletRequest request, HttpServletResponse response, String key, String data)
	    throws IOException {
	HttpSession session = request.getSession();
	TableStatusBean tableStatusBean = null;
	UsersService usersService = ServiceFactory.getFactory().getUserService();
	CoursesService coursesService = ServiceFactory.getFactory().getCoursesService();
	GroupsService groupsService = ServiceFactory.getFactory().getGroupsService();
	DataGroupsService dataGroupsService = ServiceFactory.getFactory().getDataGroupsService();
	switch (key) {
	case LOG_OUT:
	    session.invalidate();
	    response.sendRedirect("index.html");
	    return;
	case USERS_TABLE:
	    session.setAttribute("userTable", usersService.loadAllUsers());
	    session.setAttribute("addStatus", false);
	    session.setAttribute("editStatus", false);
	    session.removeAttribute("editUser");
	    session.removeAttribute("user");
	    tableStatusBean = new TableStatusBean(true, false, false, false);
	    break;
	case COURSES_TABLE:
	    session.setAttribute("coursesTable", coursesService.loadAllCourses());
	    session.setAttribute("addStatusCourse", false);
	    session.setAttribute("editStatusCourse", false);
	    session.removeAttribute("editCourse");
	    session.removeAttribute("course");
	    tableStatusBean = new TableStatusBean(false, true, false, false);
	    break;
	case GROUPS_TABLE:
	    session.setAttribute("groupsTable", groupsService.loadAllGroups());
	    session.setAttribute("addStatusGroup", false);
	    session.setAttribute("editStatusGroup", false);
	    session.removeAttribute("editGroup");
	    session.removeAttribute("group");
	    tableStatusBean = new TableStatusBean(false, false, true, false);
	    break;
	case DATA_GROUPS_TABLE:
	    session.setAttribute("dataGroupsTable", dataGroupsService.loadAllDataGroups());
	    session.setAttribute("addStatusDataGroup", false);
	    session.setAttribute("editStatusDataGroup", false);
	    session.removeAttribute("dataGroup");
	    tableStatusBean = new TableStatusBean(false, false, false, true);
	    break;
	case ADD_USER:
	    session.setAttribute("editStatus", false);
	    session.setAttribute("addStatus", true);
	    session.removeAttribute("editUser");
	    session.removeAttribute("user");
	    tableStatusBean = new TableStatusBean(true, false, false, false);
	    break;
	case ADD_COURSE:
	    session.setAttribute("editStatusCourse", false);
	    session.setAttribute("addStatusCourse", true);
	    session.removeAttribute("editCourse");
	    session.removeAttribute("course");
	    tableStatusBean = new TableStatusBean(false, true, false, false);
	    break;
	case ADD_GROUP:
	    session.setAttribute("editStatusGroup", false);
	    session.setAttribute("addStatusGroup", true);
	    session.removeAttribute("editGroup");
	    session.removeAttribute("group");
	    session.setAttribute("teacher", usersService.loadAllTeacher());
	    session.setAttribute("course", coursesService.loadAllCourses());
	    tableStatusBean = new TableStatusBean(false, false, true, false);
	    break;
	case ADD_DATA_GROUP:
	    session.setAttribute("editStatusDataGroup", false);
	    session.setAttribute("addStatusDataGroup", true);
	    session.removeAttribute("dataGroup");
	    session.setAttribute("listener", usersService.loadAllListener());
	    session.setAttribute("group", groupsService.loadAllGroupsNotClose());
	    tableStatusBean = new TableStatusBean(false, false, false, true);
	    break;
	case SAVE_USER:
	    UserBean userBean = createUserBean(request);
	    if (StringUtils.isNoneBlank(userBean.getLogin(), userBean.getPassword(), userBean.getRole(),
		    userBean.getLastName(), userBean.getFirstName(), userBean.getMiddleName())) {
		userBean = usersService.addUser(userBean);
		if (!userBean.getErrorStatus()) {
		    session.setAttribute("addStatus", false);
		    List<UserBean> allUsersSU = usersService.loadAllUsers();
		    session.setAttribute("userTable", allUsersSU);
		}
	    } else {
		userBean.setErrorStatus(true);
		userBean.setErrorMessage(ERROR_MESSAGE);
	    }
	    session.setAttribute("user", userBean);
	    tableStatusBean = new TableStatusBean(true, false, false, false);
	    break;
	case SAVE_COURSE:
	    CourseBean coursesBean = createCourseBean(request);
	    if (StringUtils.isNoneBlank(coursesBean.getCourseName(), coursesBean.getDescription(),
		    coursesBean.getStatusCourse())) {
		coursesBean = coursesService.addCourse(coursesBean);
		if (!coursesBean.getErrorStatus()) {
		    session.setAttribute("addStatusCourse", false);
		    List<CourseBean> loadAllCoursesSC = coursesService.loadAllCourses();
		    session.setAttribute("coursesTable", loadAllCoursesSC);
		}
	    } else {
		coursesBean.setErrorStatus(true);
		coursesBean.setErrorMessage(ERROR_MESSAGE);
	    }
	    session.setAttribute("course", coursesBean);
	    tableStatusBean = new TableStatusBean(false, true, false, false);
	    break;
	case SAVE_GROUP:
	    GroupBean groupBeanSG = createGroupBean(request);
	    if (groupBeanSG.getIdTeacher() != null && groupBeanSG.getIdCourse() != null
		    && groupBeanSG.getStatusGroup() != null) {
		groupBeanSG = groupsService.addGroup(groupBeanSG);
		session.setAttribute("addStatusGroup", false);
		List<GroupBean> loadAllGroupsSG = groupsService.loadAllGroups();
		session.setAttribute("groupsTable", loadAllGroupsSG);
	    } else {
		groupBeanSG.setErrorStatus(true);
		groupBeanSG.setErrorMessage(ERROR_MESSAGE);
	    }
	    session.setAttribute("group", groupBeanSG);
	    tableStatusBean = new TableStatusBean(false, false, true, false);
	    break;
	case SAVE_DATA_GROUP:
	    DataGroupBean bean = createDataGroupBean(request);
	    if (bean.getIdGroup() != null && bean.getIdListener() != null) {
		bean = dataGroupsService.addDataGroup(bean);
		session.setAttribute("addStatusDataGroup", false);
		session.setAttribute("dataGroupsTable", dataGroupsService.loadAllDataGroups());
	    } else {
		bean.setErrorStatus(true);
		bean.setErrorMessage(ERROR_MESSAGE);
	    }
	    session.setAttribute("dataGroup", bean);
	    tableStatusBean = new TableStatusBean(false, false, false, true);
	    break;
	case UPDATE_USER:
	    UserBean updateUserBean = createUserBean(request);
	    updateUserBean.setIdUser(Integer.parseInt(data));
	    if (StringUtils.isNoneBlank(updateUserBean.getLogin(), updateUserBean.getPassword(),
		    updateUserBean.getRole(), updateUserBean.getLastName(), updateUserBean.getFirstName(),
		    updateUserBean.getMiddleName())) {
		updateUserBean = usersService.editUser(updateUserBean);
		if (!updateUserBean.getErrorStatus()) {
		    session.setAttribute("editStatus", false);
		    session.setAttribute("userTable", usersService.loadAllUsers());
		}
	    } else {
		updateUserBean.setErrorStatus(true);
		updateUserBean.setErrorMessage(ERROR_MESSAGE);
	    }
	    session.setAttribute("user", updateUserBean);
	    tableStatusBean = new TableStatusBean(true, false, false, false);
	    break;
	case UPDATE_COURSE:
	    CourseBean updateCoursesBean = createCourseBean(request);
	    updateCoursesBean.setIdCourse(Integer.parseInt(data));
	    if (StringUtils.isNoneBlank(updateCoursesBean.getCourseName(), updateCoursesBean.getDescription(),
		    updateCoursesBean.getStatusCourse())) {
		updateCoursesBean = coursesService.editCourser(updateCoursesBean);
		if (!updateCoursesBean.getErrorStatus()) {
		    session.setAttribute("editStatusCourse", false);
		    session.setAttribute("coursesTable", coursesService.loadAllCourses());
		}
	    } else {
		updateCoursesBean.setErrorStatus(true);
		updateCoursesBean.setErrorMessage(ERROR_MESSAGE);
	    }
	    session.setAttribute("course", updateCoursesBean);
	    tableStatusBean = new TableStatusBean(false, true, false, false);
	    break;
	case UPDATE_GROUP:
	    GroupBean groupBean = createGroupBean(request);
	    groupBean.setIdGroup(Integer.parseInt(data));
	    session.setAttribute("editStatusGroup", false);
	    session.setAttribute("group", groupsService.editGroup(groupBean));
	    session.setAttribute("groupsTable", groupsService.loadAllGroups());
	    tableStatusBean = new TableStatusBean(false, false, true, false);
	    break;
	case UPDATE_DATA_GROUP:
	    DataGroupBean beanUDG = createDataGroupBean(request);
	    beanUDG.setIdDataGroup(Integer.parseInt(data));
	    session.setAttribute("editStatusDataGroup", false);
	    session.setAttribute("dataGroup", dataGroupsService.editDataGroup(beanUDG));
	    session.setAttribute("dataGroupsTable", dataGroupsService.loadAllDataGroups());
	    tableStatusBean = new TableStatusBean(false, false, false, true);
	    break;
	case EDIT_USERS:
	    session.setAttribute("addStatus", false);
	    session.setAttribute("editStatus", true);
	    session.removeAttribute("editUser");
	    session.removeAttribute("user");
	    session.setAttribute("editUser", usersService.loadUserDataById(Integer.parseInt(data)));
	    tableStatusBean = new TableStatusBean(true, false, false, false);
	    break;
	case EDIT_COURSES:
	    session.setAttribute("editStatusCourse", true);
	    session.setAttribute("addStatusCourse", false);
	    session.removeAttribute("editCourse");
	    session.removeAttribute("course");
	    session.setAttribute("editCourse", coursesService.loadCourseById(Integer.parseInt(data)));
	    tableStatusBean = new TableStatusBean(false, true, false, false);
	    break;
	case EDIT_GROUPS:
	    session.setAttribute("addStatusGroup", false);
	    session.setAttribute("editStatusGroup", true);
	    session.removeAttribute("group");
	    session.setAttribute("editGroup", groupsService.loadGroupById(Integer.parseInt(data)));
	    session.setAttribute("teacher", usersService.loadAllTeacher());
	    session.setAttribute("course", coursesService.loadAllCourses());
	    tableStatusBean = new TableStatusBean(false, false, true, false);
	    break;
	case EDIT_DATA_GROUP:
	    session.setAttribute("addStatusDataGroup", false);
	    session.setAttribute("editStatusDataGroup", true);
	    session.removeAttribute("dataGroup");
	    session.setAttribute("editDataGroup", dataGroupsService.loadDataGroupsById(Integer.parseInt(data)));
	    session.setAttribute("listener", usersService.loadAllListener());
	    session.setAttribute("group", groupsService.loadAllGroupsNotClose());
	    tableStatusBean = new TableStatusBean(false, false, false, true);
	    break;
	case DELETE_USERS:
	    usersService.deleteUser(Integer.parseInt(data));
	    session.setAttribute("userTable", usersService.loadAllUsers());
	    tableStatusBean = new TableStatusBean(true, false, false, false);
	    break;
	case DELETE_COURSES:
	    coursesService.deleteCourse(Integer.parseInt(data));
	    session.setAttribute("coursesTable", coursesService.loadAllCourses());
	    tableStatusBean = new TableStatusBean(false, true, false, false);
	    break;
	case DELETE_GROUPS:
	    groupsService.deleteGroup(Integer.parseInt(data));
	    session.setAttribute("groupsTable", groupsService.loadAllGroups());
	    tableStatusBean = new TableStatusBean(false, false, true, false);
	    break;
	case DELETE_DATA_GROUP:
	    dataGroupsService.deleteDataGroup(Integer.parseInt(data));
	    session.setAttribute("dataGroupsTable", dataGroupsService.loadAllDataGroups());
	    tableStatusBean = new TableStatusBean(false, false, false, true);
	    break;
	default:
	    session.setAttribute("userTable", usersService.loadAllUsers());
	    tableStatusBean = new TableStatusBean(true, false, false, false);
	    break;
	}
	session.setAttribute(TABLE_STATUS, tableStatusBean);
	response.sendRedirect("admin.html");
    }

    private UserBean createUserBean(HttpServletRequest request) {
	String login = request.getParameter("login");
	String password = request.getParameter("password");
	String role = request.getParameter("role");
	String lastName = request.getParameter("lastName");
	String firstName = request.getParameter("firstName");
	String middleName = request.getParameter("middleName");
	UserBean userBean = new UserBean();
	userBean.setLogin(login);
	userBean.setPassword(password);
	userBean.setLastName(lastName);
	userBean.setRole(role);
	userBean.setFirstName(firstName);
	userBean.setMiddleName(middleName);
	return userBean;
    }

    private GroupBean createGroupBean(HttpServletRequest request) {
	Integer idTeacher = null;
	Integer idCourse = null;
	String statusGroup = null;
	if (request.getParameter("id teacher") != null) {
	    idTeacher = Integer.parseInt(request.getParameter("id teacher"));
	}
	if (request.getParameter("id course") != null) {
	    idCourse = Integer.parseInt(request.getParameter("id course"));
	}
	if (request.getParameter("status group") != null) {
	    statusGroup = request.getParameter("status group");
	}
	GroupBean result = new GroupBean();
	result.setIdTeacher(idTeacher);
	result.setIdCourse(idCourse);
	result.setStatusGroup(statusGroup);
	return result;
    }

    private CourseBean createCourseBean(HttpServletRequest request) {
	String courseName = request.getParameter("course name");
	String description = request.getParameter("description");
	String statusCourse = request.getParameter("status course");
	CourseBean coursesBean = new CourseBean();
	coursesBean.setCourseName(courseName);
	coursesBean.setDescription(description);
	coursesBean.setStatusCourse(statusCourse);
	return coursesBean;
    }

    private DataGroupBean createDataGroupBean(HttpServletRequest request) {
	Integer idGroup = null;
	Integer idListener = null;
	if (request.getParameter("id group") != null) {
	    idGroup = Integer.parseInt(request.getParameter("id group"));
	}
	if (request.getParameter("id listener") != null) {
	    idListener = Integer.parseInt(request.getParameter("id listener"));
	}
	DataGroupBean result = new DataGroupBean();
	result.setIdGroup(idGroup);
	result.setIdListener(idListener);
	return result;
    }

}
