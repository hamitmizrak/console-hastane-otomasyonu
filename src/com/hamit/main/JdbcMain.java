package com.hamit.main;

import com.hami.controller.AdminController;

public class JdbcMain {

	public static void main(String[] args) {
		AdminController adminController = new AdminController();
		while (true) {
			adminController.switchCaseMethod();
		}

	}

}
