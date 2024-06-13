package edu.cesur.ordinaria.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection connection;
	private static String dbname = "Hospital";

	private DatabaseConnection() {
	}

	public static Connection getConnection() {

		try {
			if (connection == null || connection.isClosed()) {
				String url = "jdbc:postgresql://localhost:5432/" + dbname;
				String user = "postgres";
				String password = "1234";
				connection = DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			System.out.println("SQL State: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Message: " + e.getMessage());
			Throwable t = e.getCause();
			while (t != null) {
				System.out.println("Cause: " + t);
				t = t.getCause();
			}
		}
		return connection;

	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Database connection closed.");
			} catch (SQLException e) {
				System.out.println("Failed to close the connection.");
				e.printStackTrace();
			}
		}
	}
}