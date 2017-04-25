package com.example.tms.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.tms.beans.CourseBean;
import com.example.tms.dao.CoursesListDAO;
import com.example.tms.dao.factory.DAOFactory;
import com.example.tms.domain.CoursesListEntity;
import com.example.tms.services.CoursesService;
import com.example.tms.services.converter.BeanToEntityConverter;
import com.example.tms.services.converter.EntityToBeanConverter;

public class CoursesServiceImpl implements CoursesService {

	@Override
	public List<CourseBean> loadAllCourses() {
		List<CourseBean> result = new ArrayList<>();
		CoursesListDAO coursesListDAO = DAOFactory.getFactory().getCoursesListDAO();
		List<CoursesListEntity> loadAllCourses = coursesListDAO.loadAllCourses();
		for (CoursesListEntity course : loadAllCourses) {
			result.add(EntityToBeanConverter.createCoursesBean(course));
		}
		return result;
	}

	@Override
	public CourseBean loadCourseById(Integer userId) {
		CoursesListDAO coursesListDAO = DAOFactory.getFactory().getCoursesListDAO();
		CoursesListEntity createCoursesListEntity = BeanToEntityConverter.createCoursesListEntity(userId);
		CoursesListEntity loadCourseById = coursesListDAO.loadCourseById(createCoursesListEntity);
		CourseBean result = EntityToBeanConverter.createCoursesBean(loadCourseById);
		return result;
	}

	@Override
	public CourseBean addCourse(CourseBean bean) {
		CoursesListDAO coursesListDAO = DAOFactory.getFactory().getCoursesListDAO();
		CoursesListEntity entity = BeanToEntityConverter.createCoursesListEntity(bean);
		if (coursesListDAO.checkDuplicateCourseName(entity)) {
			bean.setErrorStatus(true);
			bean.setErrorMessage("Error! The course with this name already exists.");
		} else {
			bean.setErrorStatus(false);
			bean.setErrorMessage("Information! The course was successfully added.");
			coursesListDAO.addCourse(entity);
		}
		return bean;
	}

	@Override
	public CourseBean editCourser(CourseBean bean) {
		CourseBean result = new CourseBean();
		CoursesListDAO coursesListDAO = DAOFactory.getFactory().getCoursesListDAO();
		coursesListDAO.editCourse(BeanToEntityConverter.createCoursesListEntity(bean));
		result.setErrorStatus(false);
		result.setErrorMessage("Information! User updated successfully.");
		return result;
	}

	@Override
	public void deleteCourse(Integer id) {
		CoursesListDAO coursesListDAO = DAOFactory.getFactory().getCoursesListDAO();
		CoursesListEntity entity = new CoursesListEntity();
		entity.setId(id);
		coursesListDAO.deleteCourse(entity);
	}

}
