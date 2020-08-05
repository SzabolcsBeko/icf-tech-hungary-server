package com.restapp.service;

import java.util.List;

import com.restapp.entity.Client;
import com.restapp.recaptcha.LoginRequest;
import com.restapp.recaptcha.LoginResponse;


public interface ClientService {

	public Client getClientById(Long clientId);
	
	public Client getClientByNameAndPassword(String name, String password);
	
	public List<Client> getAllClients();
	
	public void insertClient(Client client);
	
	public LoginResponse login(LoginRequest loginRequest);
}
