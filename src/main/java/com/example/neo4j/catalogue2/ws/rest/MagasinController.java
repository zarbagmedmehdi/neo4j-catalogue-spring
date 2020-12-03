package com.example.neo4j.catalogue2.ws.rest;

import com.example.neo4j.catalogue2.bean.Magasin;
import com.example.neo4j.catalogue2.service.MagasinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magasin")
@CrossOrigin(origins = "http://localhost:4200")
public class MagasinController {
    @Autowired
    public MagasinService magasinService;

    @PostMapping("/")
    public int save(@RequestBody Magasin magasin) {
        return magasinService.save(magasin);
    }
    @GetMapping("/")
    public List<Magasin> findAll() {
        return magasinService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody Magasin magasin)
    {
        System.out.println(magasin);
        return magasinService.save(magasin);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        magasinService.deleteById( id);
        return "magasin deleted with id : " + id;
    }
}
