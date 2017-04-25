package com.example.tms.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.tms.dao.UserDataDAO;
import com.example.tms.dao.exception.DaoException;
import com.example.tms.dao.mysql.db.ConnectionPool;
import com.example.tms.dao.mysql.db.ResultSetConverter;
import com.example.tms.domain.UserDataEntity;
import com.example.tms.domain.UsersEntity;

public class MySqlUserDataDAO implements UserDataDAO {

	@Override
	public List<UserDataEntity> loadAllUserData() throws DaoException {
		String query = "SELECT * FROM user_data;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<UserDataEntity> result = new ArrayList<>();
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(ResultSetConverter.createUserDataEntity(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public UserDataEntity loadUserDataById(UsersEntity entity) throws DaoException {
		String query = "SELECT * FROM user_data WHERE id_user_data = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserDataEntity result = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, entity.getId());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				result = ResultSetConverter.createUserDataEntity(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public void addUserData(UserDataEntity entity) throws DaoException {
		String query = "INSERT INTO user_data VALUES (?,?,?,?);";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, entity.getId());
			statement.setString(2, entity.getLastName());
			statement.setString(3, entity.getFirstName());
			statement.setString(4, entity.getMiddleName());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	@Override
	public void editUserData(UserDataEntity entity) throws DaoException {
		String query = "UPDATE user_data SET last_name = ?, first_name = ?, middle_name = ?  WHERE id_user_data = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, entity.getLastName());
			statement.setString(2, entity.getFirstName());
			statement.setString(3, entity.getMiddleName());
			statement.setInt(4, entity.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}
}
