package com.example.neo4j.catalogue2.service;

import com.example.neo4j.catalogue2.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
}
