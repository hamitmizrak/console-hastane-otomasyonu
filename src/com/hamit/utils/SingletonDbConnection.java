package com.hamit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.java.Log;

@Log
public class SingletonDbConnection {

	// for mysql
	private String user = "root";
	private String password = "root";
	private String url = "jdbc:mysql://localhost:3306/hastane_otomasyonu??useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true&useSSL=false";
	private Connection connection = null;

	// singleton Design pattern
	private static SingletonDbConnection instance;

	private SingletonDbConnection() {
	}

	public static SingletonDbConnection getSingletonDbConnection() {
		if (instance == null) {
			synchronized (javax.inject.Singleton.class) {
				if (instance == null) {
					instance = new SingletonDbConnection();
				}
			}
		}
		return instance;
	}

	// Connection
	public Connection getConnection() {
		try {
			// driver yüklenmesi
			Class.forName("com.mysql.jdbc.Driver");
			log.info("Driver installed");
			// connection =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/hastane_otomasyonu??useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true&useSSL=false",
			// "root", "root");
			connection = DriverManager.getConnection(url, user, password);
			log.info("Success connected");
		} catch (SQLException | ClassNotFoundException e) {
			log.warning(e + " ");
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		}
		return connection;
	}

	// public static void main(String[] args) {
	// SingletonDbConnection connection = new SingletonDbConnection();
	// connection.getConnection();
	// }

}
