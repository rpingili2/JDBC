package com.infor.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static String DB_USER_NAME;
	private static String DB_PASSWORD;
	private static String DB_URL;
	private static String DRIVER_CLASS;
	static{
		try {
				FileInputStream fis = new FileInputStream("db.properties");
				Properties ps = new Properties();
				ps.load(fis);
				DB_USER_NAME = ps.getProperty("USER_NAME");
				DB_PASSWORD = ps.getProperty("PASSWORD");
				DB_URL = ps.getProperty("URL");
				DRIVER_CLASS = ps.getProperty("DRIVER_CLASS");
			} catch(FileNotFoundException ene) {
				System.out.println("Fail to found DB properties");
			} catch (IOException e) {
				System.out.println("Fail to load properties");
		}
	}
	public static Connection getDBConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER_CLASS);
			conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
