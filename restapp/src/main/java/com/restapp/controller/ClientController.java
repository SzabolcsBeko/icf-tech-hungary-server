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

	@GetMapping("/clients")
	public List<Client> getClients() {
		List<Client> clients = service.getAllClients();
		return clients;
	}

	@GetMapping("/clients/{clientId}")
	public Client getClient(@PathVariable(name = "clientId") Long clientId) {
		return service.getClient(clientId);
	}

	@GetMapping("/clients/name/{clientName}")
	public Client getClient(@PathVariable(name = "clientName") String clientName) {
		List<Client> result = service.getAllClients().stream().filter(c -> c.getName().equals(clientName)).limit(2)
				.collect(Collectors.toList());
		if (result.size() != 1) {
			throw new IllegalStateException("Expected exactly one client but got " + result);
		}
		return result.get(0);
	}

	@PostMapping("/clients/id/{id}")
	public void saveTransaction(Client client) {
		service.saveClient(client);
		System.out.println("Client Saved Successfully");
	}

	@PutMapping("/clients/{id}")
	public void updateClient(@PathVariable(name = "id") Long id, @RequestBody Client client) {
		Client clnt = service.getClient(id);
		if (clnt != null) {
			service.updateClient(client);
		}
	}

}
