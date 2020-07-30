package com.restapp.dto;

import lombok.Data;

@Data
public class ClientDto {
	private String id;
	private String name;
	private String password;
	private String lastLogin;
	private String role;
}
