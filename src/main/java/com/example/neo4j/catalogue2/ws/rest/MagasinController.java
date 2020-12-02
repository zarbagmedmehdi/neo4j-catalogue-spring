package com.example.neo4j.catalogue2.ws.rest;

import com.example.neo4j.catalogue2.bean.Magasin;
import com.example.neo4j.catalogue2.service.MagasinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/magasin")
public class MagasinController {
    @Autowired
    public MagasinService magasinService;

    @PostMapping("/")
    public int save(@RequestBody Magasin magasin) {
        return magasinService.save(magasin);
    }
    @GetMapping("/")
    public Iterable<Magasin> findAll() {
        return magasinService.findAll();
    }
}
