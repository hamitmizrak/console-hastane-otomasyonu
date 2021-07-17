package com.hamit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hamit.dto.AdminDto;

import lombok.extern.java.Log;

@Log
public class AdminDao implements IDaoImpl<AdminDto> {

	// insert admin9 (admin_name,admin_surname,admin_email,admin_password) values
	// ("Hamit","Mızrak","hamitmizrak@gmail.com","123456");
	@Override
	public void getCreate(AdminDto adminDto) {
		try (Connection connection = getDbConnection()) {
			String sql = "insert admin9 (admin_name,admin_surname,admin_email,admin_password) values (?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, adminDto.getAdminName());
			preparedStatement.setString(2, adminDto.getAdminSurname());
			preparedStatement.setString(3, adminDto.getAdminEmail());
			preparedStatement.setString(4, adminDto.getAdminPassword());
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				log.info(AdminDto.class + " ekleme başarılı");
			} else {
				log.warning(AdminDto.class + " ekleme başarısız");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update admin9 set admin_name="ad",admin_surname="soyad",admin_email="email",admin_password="şifre" where
	// admin_id=5;
	@Override
	public void getUpdate(AdminDto adminDto) {
		try (Connection connection = getDbConnection()) {
			String sql = "update admin9 set admin_name=?,admin_surname=?,admin_email=?,admin_password=? where admin_id=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, adminDto.getAdminName());
			preparedStatement.setString(2, adminDto.getAdminSurname());
			preparedStatement.setString(3, adminDto.getAdminEmail());
			preparedStatement.setString(4, adminDto.getAdminPassword());
			preparedStatement.setInt(5, adminDto.getAdminId());
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				log.info(AdminDto.class + " güncelle başarılı");
			} else {
				log.warning(AdminDto.class + " güncelleme başarısız");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// delete from admin9 where admin_id=3;
	@Override
	public void getDelete(int id) {
		try (Connection connection = getDbConnection()) {
			String sql = "delete from admin9 where admin_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				log.info(AdminDto.class + " silme başarılı");
			} else {
				log.warning(AdminDto.class + " silme başarısız");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// select * from admin9;
	@Override
	public ArrayList<AdminDto> list() {
		AdminDto adminDto;
		ArrayList<AdminDto> adminDtoList = new ArrayList<>();
		try (Connection connection = getDbConnection()) {
			String sql = "select * from admin9 order by admin_id desc limit 10";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				adminDto = new AdminDto();
				adminDto.setAdminId(resultSet.getInt("admin_id"));
				adminDto.setAdminEmail(resultSet.getString("admin_email"));
				adminDto.setAdminName(resultSet.getString("admin_name"));
				adminDto.setAdminPassword(resultSet.getString("admin_password"));
				adminDto.setAdminSurname(resultSet.getString("admin_surname"));
				adminDto.setCreationDate(resultSet.getDate("creation_date"));
				adminDtoList.add(adminDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return adminDtoList;
	}

	// listelemeyi göstermek
	public void showList() {
		ArrayList<AdminDto> adminDtoList = list();
		if (list() != null) {
			for (AdminDto temp : adminDtoList) {
				System.out.println(temp + " ");
			}
		}

	}

}
