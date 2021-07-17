package com.hamit.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.hamit.utils.SingletonDbConnection;

public interface IDaoImpl<T> {
	// CRUD
	public void getCreate(T t);

	public void getUpdate(T t);

	public void getDelete(int id);

	public ArrayList<T> list();

	// getConnection
	default Connection getDbConnection() {
		return SingletonDbConnection.getSingletonDbConnection().getConnection();
	}

}
