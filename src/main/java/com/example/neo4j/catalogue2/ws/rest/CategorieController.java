package com.example.neo4j.catalogue2.ws.rest;

import com.example.neo4j.catalogue2.bean.Categorie;
import com.example.neo4j.catalogue2.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    CategorieService categorieService;
    
    @PostMapping("/")
    public int save(@RequestBody Categorie categorie){
        return categorieService.save(categorie);
    }
}
