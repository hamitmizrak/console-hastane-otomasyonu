package com.hami.controller;

import java.util.Scanner;

import com.hamit.dao.AdminDao;
import com.hamit.dto.AdminDto;

import lombok.extern.java.Log;

@Log
public class AdminController {
	private AdminDao adminDao;

	// CRUD
	// Create
	public void create(AdminDto adminDto) {
		adminDao.getCreate(adminDto);
	}

	public void delete(AdminDto adminDto) {
		adminDao.getDelete(adminDto);
	}

	public void update(AdminDto adminDto) {
		adminDao.getDelete(adminDto);
	}

	public void list() {
		adminDao.showList();
	}

	public int chooise() {
		Scanner klavye = new Scanner(System.in);
		System.out.println("Lütfen bir seçim yapınız.");
		System.out.println("1-)Ekleme\n2-)Güncelleme\n3-)Silme\n4-)Listeleme\n5-)Çıkış");
		int result = klavye.nextInt();
		return result;
	}

	public void switchCaseMethod() {
		AdminDao adminDao = new AdminDao();
		Scanner klavye = new Scanner(System.in);
		int result = chooise();
		switch (result) {
			case 1:
				System.out.println("\n *********** Ekleme *********");
				String name, surname, emailAddress, password;
				System.out.println("Adınız");
				name = klavye.nextLine();

				System.out.println("Soyadınız");
				surname = klavye.nextLine();

				System.out.println("Email adresiniz");
				emailAddress = klavye.nextLine();

				System.out.println("Şifreniz");
				password = klavye.nextLine();

				AdminDto adminDto = new AdminDto();
				adminDto = new AdminDto();
				adminDto.setAdminEmail(emailAddress);
				adminDto.setAdminName(name);
				adminDto.setAdminPassword(password);
				adminDto.setAdminSurname(surname);
				adminDao.getCreate(adminDto);

				break;

			case 2:
				System.out.println("\n *********** Güncelleme *********");
				adminDao.showList();
				String uname, usurname, uemailAddress, upassword;
				int uid;

				System.out.println("Adınız");
				uname = klavye.nextLine();

				System.out.println("Soyadınız");
				usurname = klavye.nextLine();

				System.out.println("Email adresiniz");
				uemailAddress = klavye.nextLine();

				System.out.println("Şifreniz");
				upassword = klavye.nextLine();

				System.out.println("Güncellenecek id");
				uid = klavye.nextInt();

				AdminDto adminDto2 = new AdminDto();
				adminDto2.setAdminId(uid);
				adminDto2.setAdminEmail(uemailAddress);
				adminDto2.setAdminName(uname);
				adminDto2.setAdminPassword(upassword);
				adminDto2.setAdminSurname(usurname);
				adminDao.getUpdate(adminDto2);
				break;

			case 3:
				System.out.println("\n *********** Silme ************");
				adminDao.showList();
				System.out.println("Silmek istediğiniz id giriniz");
				int delete = klavye.nextInt();

				AdminDto adminDto3 = new AdminDto();
				adminDto3.setAdminId(delete);
				adminDao.getDelete(adminDto3);
				break;

			case 4:
				System.out.println("\n *********** Listeleme *********");
				adminDao.showList();
				break;

			case 5:
				System.out.println("\n *********** Çıkış *********");
				System.exit(0);
				break;

			default:
				break;
		}
	}

}
