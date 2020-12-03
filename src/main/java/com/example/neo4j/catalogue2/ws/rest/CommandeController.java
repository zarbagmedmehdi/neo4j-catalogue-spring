package com.example.neo4j.catalogue2.ws.rest;

import com.example.neo4j.catalogue2.bean.Client;
import com.example.neo4j.catalogue2.bean.Commande;
import com.example.neo4j.catalogue2.service.ClientService;
import com.example.neo4j.catalogue2.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    CommandeService commandeService;
    @Autowired
    ClientService clientService;
    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        System.out.println(commande);
        return commandeService.save(commande);
    }
    @GetMapping("/{id}")
    public List<Commande> findByClient(@PathVariable  long id){
        Client client=clientService.findById(id);
        System.out.println(client);
      return  commandeService.findByClient ( client);
    }
}
