package com.hamit.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDto implements Serializable {
	private static final long serialVersionUID = 2440857140658404052L;

	private int adminId;
	private String adminName;
	private String adminSurname;
	private String adminEmail;
	private String adminPassword;
	private java.util.Date creationDate;

}
