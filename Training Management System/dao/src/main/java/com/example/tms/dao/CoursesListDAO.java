package com.example.tms.dao;

import java.util.List;

import com.example.tms.dao.exception.DaoException;
import com.example.tms.domain.CoursesListEntity;

public interface CoursesListDAO {

	List<CoursesListEntity> loadAllCourses() throws DaoException;
	
	CoursesListEntity loadCourseById(CoursesListEntity entity) throws DaoException;

	Boolean checkDuplicateCourseName(CoursesListEntity entity) throws DaoException;

	void addCourse(CoursesListEntity entity) throws DaoException;

	void editCourse(CoursesListEntity entity) throws DaoException;

	void deleteCourse(CoursesListEntity entity) throws DaoException;

}
