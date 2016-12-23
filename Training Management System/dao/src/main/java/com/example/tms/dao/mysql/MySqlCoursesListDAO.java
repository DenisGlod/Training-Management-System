package com.example.tms.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.tms.dao.CoursesListDAO;
import com.example.tms.dao.exception.DaoException;
import com.example.tms.dao.mysql.db.ConnectionPool;
import com.example.tms.dao.mysql.db.ResultSetConverter;
import com.example.tms.domain.CoursesListEntity;

public class MySqlCoursesListDAO implements CoursesListDAO {

	@Override
	public List<CoursesListEntity> loadAllCourses() throws DaoException {
		String query = "SELECT * FROM courses_list;";
		List<CoursesListEntity> result = new ArrayList<CoursesListEntity>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(ResultSetConverter.createCoursesListEntity(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public CoursesListEntity loadCourseById(CoursesListEntity entity) throws DaoException {
		String query = "SELECT * FROM courses_list WHERE id_course = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		CoursesListEntity result = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, entity.getId());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				result = ResultSetConverter.createCoursesListEntity(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public Boolean checkDuplicateCourseName(CoursesListEntity entity) throws DaoException {
		String query = "SELECT * FROM courses_list WHERE course_name = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Boolean result = false;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, entity.getCourseName());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				result = true;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public void addCourse(CoursesListEntity entity) throws DaoException {
		String query = "INSERT INTO courses_list (course_name, description, status_course) VALUES (?,?,?);";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, entity.getCourseName());
			statement.setString(2, entity.getDescription());
			statement.setString(3, entity.getStatus());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	@Override
	public void editCourse(CoursesListEntity entity) throws DaoException {
		String query = "UPDATE courses_list SET course_name = ?, description = ?, status_course = ? WHERE id_course = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, entity.getCourseName());
			statement.setString(2, entity.getDescription());
			statement.setString(3, entity.getStatus());
			statement.setInt(4, entity.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	@Override
	public void deleteCourse(CoursesListEntity entity) throws DaoException {
		String query = "DELETE FROM courses_list WHERE id_course = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, entity.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

}
