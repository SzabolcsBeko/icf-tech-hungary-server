package com.restapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapp.entity.Client;
import com.restapp.service.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private ClientService service;

	public ClientController(ClientService clientService) {
		this.service = clientService;
	}

	@GetMapping("/clients/{clientId}")
	public Client getClientById(@PathVariable(name = "clientId") Long clientId) {
		return service.getClientById(clientId);
	}
	
	@GetMapping("/clients/name/{clientName}/password/{password}")
	public Client getClientByNameAndPassword(@PathVariable(name = "clientName") String clientName, @PathVariable(name = "password") String password) {
		return service.getClientByNameAndPassword(clientName, password);
	}
	
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		List<Client> clients = service.getAllClients();
		return clients;
	}

	@PostMapping("/clients")
	public void insertClient(@RequestBody Client client) {
		service.insertClient(client);
	}

}
