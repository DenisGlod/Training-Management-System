package com.example.tms.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.tms.dao.UsersDAO;
import com.example.tms.dao.exception.DaoException;
import com.example.tms.dao.mysql.db.ConnectionPool;
import com.example.tms.dao.mysql.db.ResultSetConverter;
import com.example.tms.domain.UsersEntity;

public class MySqlUsersDAO extends MySqlBaseDAO implements UsersDAO {

	@Override
	public List<UsersEntity> loadAllUsers() throws DaoException {
		String query = "SELECT * FROM users";
		List<UsersEntity> result = new ArrayList<UsersEntity>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(ResultSetConverter.createUserEntity(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public UsersEntity loadUserById(Integer userId) throws DaoException {
		String query = "SELECT * FROM users WHERE id_user = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UsersEntity result = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, userId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				result = ResultSetConverter.createUserEntity(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public Boolean checkDuplicateLogin(UsersEntity entity) throws DaoException {
		String query = "SELECT * FROM users WHERE login =?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Boolean result = false;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, entity.getLogin());
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
	public UsersEntity verificationLoginAndPassword(UsersEntity entity) throws DaoException {
		String query = "SELECT * FROM users WHERE login = ? AND password = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UsersEntity result = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, entity.getLogin());
			statement.setString(2, entity.getPassword());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				result = ResultSetConverter.createUserEntity(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public UsersEntity addUser(UsersEntity entity) throws DaoException {
		String query = "INSERT INTO users (login, password, role) VALUES (?,?,?);";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, entity.getLogin());
			statement.setString(2, entity.getPassword());
			statement.setString(3, entity.getRole());
			statement.executeUpdate();
			Integer userID = loadStoredID(statement);
			entity.setId(userID);
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
		return entity;
	}

	@Override
	public void editUser(UsersEntity entity) throws DaoException {
		String query = "UPDATE users SET login = ?, password = ?, role = ? WHERE id_user = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, entity.getLogin());
			statement.setString(2, entity.getPassword());
			statement.setString(3, entity.getRole());
			statement.setInt(4, entity.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	@Override
	public void deleteUser(Integer userId) throws DaoException {
		String query = "DELETE FROM users WHERE id_user = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, userId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

}
