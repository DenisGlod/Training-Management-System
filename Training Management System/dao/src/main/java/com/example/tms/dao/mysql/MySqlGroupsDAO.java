package com.example.tms.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.tms.dao.GroupsDAO;
import com.example.tms.dao.exception.DaoException;
import com.example.tms.dao.mysql.db.ConnectionPool;
import com.example.tms.dao.mysql.db.ResultSetConverter;
import com.example.tms.domain.GroupsEntity;

public class MySqlGroupsDAO implements GroupsDAO {

	@Override
	public List<GroupsEntity> loadAllGroups() throws DaoException {
		String query = "SELECT * FROM groups;";
		List<GroupsEntity> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(ResultSetConverter.createGroupsEntity(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public List<GroupsEntity> loadGroupByIdTeacher(Integer idTeacher) throws DaoException {
		String query = "SELECT * FROM groups WHERE id_teacher = ?;";
		List<GroupsEntity> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, idTeacher);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(ResultSetConverter.createGroupsEntity(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public GroupsEntity loadGroupById(Integer idGroup) throws DaoException {
		String query = "SELECT * FROM groups WHERE id_group = ?;";
		GroupsEntity result = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, idGroup);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				result = ResultSetConverter.createGroupsEntity(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public void addGroup(GroupsEntity entity) throws DaoException {
		String query = "INSERT INTO groups (id_teacher, id_course, status_group) VALUES (?,?,?);";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, entity.getIdTeacher());
			statement.setInt(2, entity.getIdCourse());
			statement.setString(3, entity.getStatusGroup());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	@Override
	public void editGroup(GroupsEntity entity) throws DaoException {
		String query = "UPDATE groups SET id_teacher = ?, id_course = ?, status_group = ? WHERE id_group = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, entity.getIdTeacher());
			statement.setInt(2, entity.getIdCourse());
			statement.setString(3, entity.getStatusGroup());
			statement.setInt(4, entity.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	@Override
	public void deleteGroup(Integer groupId) throws DaoException {
		String query = "DELETE FROM groups WHERE id_group = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, groupId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

}
