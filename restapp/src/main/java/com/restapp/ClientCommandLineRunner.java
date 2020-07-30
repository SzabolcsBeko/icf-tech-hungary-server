package com.restapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restapp.respository.ClientRepository;

@Component
public class ClientCommandLineRunner implements CommandLineRunner {

	private final ClientRepository repository;

	public ClientCommandLineRunner(ClientRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		repository.findAll().forEach(System.out::println);

	}

}
