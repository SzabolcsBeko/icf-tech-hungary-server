package com.restapp.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapp.entity.Client;
import com.restapp.recaptcha.LoginRequest;
import com.restapp.recaptcha.LoginResponse;
import com.restapp.respository.ClientRepository;
import com.restapp.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
    private CaptchaService captchaService;


	public ClientServiceImpl(ClientRepository clientRepository) {
		this.repository = clientRepository;
	}

	public Client getClientById(Long clientId) {
		Optional<Client> optClients = repository.findById(clientId);
		return optClients.get();
	}
	
	public Client getClientByNameAndPassword(String name, String password) {
		List<Client> clients = repository.findClinetsByNameAndPassword(name, password);
		Client result = null; 
		if(clients.size() > 1) {
			List<Client> largestTwo = clients.stream().sorted(Comparator.comparingLong(Client::getId)
					.reversed()).limit(2).collect(Collectors.toList());
			result = largestTwo.get(1);
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
	
	@Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        boolean captchaVerified = captchaService.verify(loginRequest.getRecaptchaResponse());
        if(!captchaVerified) {
            loginResponse.setMessage("Invalid captcha");
            loginResponse.setStatus(400);
        }
        Client client = this.getClientByNameAndPassword(loginRequest.getClientName(), loginRequest.getPassword());
        if(captchaVerified && loginRequest.getClientName().equals(client.getName()) && loginRequest.getPassword().equals(client.getPassword())) {
            loginResponse.setMessage("Success");
            loginResponse.setStatus(200);
            loginResponse.setClientName(client.getName());
            loginResponse.setToken("token");
            loginResponse.setPassword(client.getPassword());
        }else {
            loginResponse.setMessage("Invalid credentials.");
            loginResponse.setStatus(400);
        }
        return loginResponse;
    }

}
