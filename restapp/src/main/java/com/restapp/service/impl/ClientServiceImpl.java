package com.restapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapp.entity.Client;
import com.restapp.respository.ClientRepository;
import com.restapp.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repository;

	public ClientServiceImpl(ClientRepository clientRepository) {
		this.repository = clientRepository;
	}

	public List<Client> getAllClients() {
		List<Client> clients = repository.findAll();
		return clients;
	}

	public Client getClient(Long clientId) {
		Optional<Client> optClients = repository.findById(clientId);
		return optClients.get();
	}

	public void saveClient(Client client) {
		repository.save(client);
	}

	@Override
	public void updateClient(Client client) {
		repository.save(client);
	}

	

}
