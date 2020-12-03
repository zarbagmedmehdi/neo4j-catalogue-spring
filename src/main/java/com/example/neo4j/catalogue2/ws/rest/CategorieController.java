package com.example.neo4j.catalogue2.ws.rest;

import com.example.neo4j.catalogue2.bean.Categorie;
import com.example.neo4j.catalogue2.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    CategorieService categorieService;
    
    @PostMapping("/")
    public int save(@RequestBody Categorie categorie){
        return categorieService.save(categorie);
    }
    @GetMapping("/")
    public List<Categorie> findAll(){return categorieService.findAll();}
}
