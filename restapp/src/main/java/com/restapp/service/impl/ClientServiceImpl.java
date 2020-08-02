package com.restapp.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	public Client getClientById(Long clientId) {
		Optional<Client> optClients = repository.findById(clientId);
		return optClients.get();
	}
	
	public Client getClientByNameAndPassword(String name, String password) {
		List<Client> clients = repository.findClinetByNameAndPassword(name, password);
		Client result = null; 
		if(clients.size() > 1) {
			List<Client> largestTwo = clients.stream().sorted(Comparator.comparingLong(Client::getId)
					.reversed()).limit(2).collect(Collectors.toList());
			result = largestTwo.get(0);
		}
		else if(clients.size() == 1) {
			result = clients.get(0);
		}
		else {
			result = new Client();
		}
		return result;
	}
	
	public List<Client> getAllClients() {
		List<Client> clients = repository.findAll();
		return clients;
	}

	public void insertClient(Client client) {
		repository.save(client);
	}

}
