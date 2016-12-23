package com.example.tms.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class MySqlBaseDAO {

	protected Integer loadStoredID(Statement statement) throws SQLException {
		try (ResultSet set = statement.getGeneratedKeys()) {
			if (set.next()) {
				Integer storedId = set.getInt(1);
				return storedId;
			}
		}
		return null;
	}

}
