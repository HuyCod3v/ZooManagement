package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lib.ConnectDbLib;

public abstract class AbstractDAO {
	static ConnectDbLib dbAccess;
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;
	static Connection connection;	
}
