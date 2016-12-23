package com.example.tms.services;

import java.util.List;

import com.example.tms.beans.CourseBean;

public interface CoursesService {

	List<CourseBean> loadAllCourses();

	CourseBean loadCourseById(Integer userId);

	CourseBean addCourse(CourseBean bean);

	CourseBean editCourser(CourseBean bean);

	void deleteCourse(Integer id);

}
