package com.restapp.service;

import java.util.List;

import com.restapp.entity.Client;


public interface ClientService {

	public List<Client> getAllClients();

	public Client getClient(Long clientId);
	
	public void saveClient(Client client);
	
	public void updateClient(Client client);
	
}
