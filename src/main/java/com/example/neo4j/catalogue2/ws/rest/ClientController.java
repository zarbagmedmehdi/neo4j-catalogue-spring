package com.example.neo4j.catalogue2.ws.rest;

import com.example.neo4j.catalogue2.bean.Client;
import com.example.neo4j.catalogue2.bean.Produit;
import com.example.neo4j.catalogue2.service.ClientService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    
    @PostMapping("/")
    public int save(@RequestBody Client client) {
        return clientService.save(client);
    }
}
