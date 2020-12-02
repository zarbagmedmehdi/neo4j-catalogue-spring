package com.example.neo4j.catalogue2.ws.rest;

import com.example.neo4j.catalogue2.bean.Client;
import com.example.neo4j.catalogue2.bean.Commande;
import com.example.neo4j.catalogue2.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    CommandeService commandeService;
    
    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }
}
