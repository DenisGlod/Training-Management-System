package com.example.tms.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.tms.dao.DataGroupsDAO;
import com.example.tms.dao.exception.DaoException;
import com.example.tms.dao.mysql.db.ConnectionPool;
import com.example.tms.dao.mysql.db.ResultSetConverter;
import com.example.tms.domain.DataGroupsEntity;
import com.example.tms.domain.UserDataEntity;

public class MySqlDataGroupsDAO implements DataGroupsDAO {

	@Override
	public Boolean checkDuplicate(DataGroupsEntity entity) throws DaoException {
		String query = "SELECT * FROM data_groups WHERE id_group = ? AND id_listener = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Boolean result = false;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, entity.getIdGroup());
			statement.setInt(2, entity.getIdListener());
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
	public List<DataGroupsEntity> loadAllDataGroups() throws DaoException {
		String query = "SELECT * FROM data_groups;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<DataGroupsEntity> result = new ArrayList<>();
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(ResultSetConverter.createDataGroupsEntity(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}
	
	@Override
	public DataGroupsEntity loadDataGroupsById(Integer idDataGroup) throws DaoException {
		String query = "SELECT * FROM data_groups WHERE id_data_group = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		DataGroupsEntity result = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, idDataGroup);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				result = ResultSetConverter.createDataGroupsEntity(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public DataGroupsEntity loadDataGroupsByIdListener(UserDataEntity entity) throws DaoException {
		String query = "SELECT * FROM data_groups WHERE id_listener = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		DataGroupsEntity result = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, entity.getId());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				result = ResultSetConverter.createDataGroupsEntity(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public void addDataGroup(DataGroupsEntity entity) throws DaoException {
		String query = "INSERT INTO data_groups (id_group, id_listener) VALUES (?,?);";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, entity.getIdGroup());
			statement.setInt(2, entity.getIdListener());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	@Override
	public void editDataGroup(DataGroupsEntity entity) throws DaoException {
		String query = "UPDATE data_groups SET id_group = ?, id_listener = ? WHERE id_data_group = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, entity.getIdGroup());
			statement.setInt(2, entity.getIdListener());
			statement.setInt(3, entity.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	@Override
	public void deleteDataGroup(Integer idDataGroup) throws DaoException {
		String query = "DELETE FROM data_groups WHERE id_data_group = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, idDataGroup);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

}
