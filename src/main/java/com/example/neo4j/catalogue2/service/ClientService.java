package com.example.neo4j.catalogue2.service;

import com.example.neo4j.catalogue2.bean.Client;
import com.example.neo4j.catalogue2.dao.ClientRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public int save(Client client) {
		if(client != null) {
			clientRepository.save(client);
			return 1;
		}
		else 
			return -1;
	}

	public Iterable<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client login(Client client)
	{
		return clientRepository.findByEmailAndPassword(client.getEmail(),client.getPassword());
	}

	public Client findById(long id)
	{
		return clientRepository.findById(id);
	}

	public Client searchComment(String comment){
		return clientRepository.searchComment(comment);
	}
    
}
