package com.hamit.test;

import com.hamit.dao.AdminDao;

public class MainTest {

	public static void main(String[] args) {
		AdminDao adminDao = new AdminDao();

		// create
		// AdminDto adminDto = new AdminDto().builder().adminEmail("hamitmizrak@gmail.com").adminName("Hamit")
		// .adminSurname("Mızrak").adminPassword("password").build();
		// adminDao.getCreate(adminDto);

		// delete
		// AdminDto adminDto = new AdminDto().builder().adminEmail("hamitmizrak@gmail.com").adminName("Hamit")
		// .adminSurname("Mızrak").adminPassword("password").build();
		// adminDao.getDelete(6);

		// update
		// AdminDto adminDto = new AdminDto().builder().adminEmail("hamitmizrak44@gmail.com").adminName("Hamit44")
		// .adminSurname("Mızrak44").adminPassword("password44").adminId(1).build();
		// adminDao.getUpdate(adminDto);

		// select
		// adminDao.showList();

	}

}
