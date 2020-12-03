package com.example.neo4j.catalogue2.ws.rest;

import com.example.neo4j.catalogue2.bean.Client;
import com.example.neo4j.catalogue2.service.ClientService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    
    @PostMapping("/")
    public int save(@RequestBody Client client) {
        System.out.println(client);
        return clientService.save(client);
    }
    @PostMapping("/login")
    public Client login(@RequestBody Client client) {
        Client c =clientService.login(client);

        if(c==null){
            c=new Client((long) -1);
        }
        System.out.println(c);

        return c;
    }
    @GetMapping("/cc")
    public void save() {

       clientService.save(new Client("zarbag","zarbag.mehdi@gmail.com", "12345", false));
        clientService.save(new Client("admin","admin.mehdi@gmail.com", "54321", true));

    }
}
