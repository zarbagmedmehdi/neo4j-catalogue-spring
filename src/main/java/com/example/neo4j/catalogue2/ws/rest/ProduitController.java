package com.example.neo4j.catalogue2.ws.rest;

import com.example.neo4j.catalogue2.bean.Magasin;
import com.example.neo4j.catalogue2.bean.Produit;
import com.example.neo4j.catalogue2.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    ProduitService produitService;

    @PostMapping("/")
    public int save(@RequestBody Produit produit) {
        System.out.println(produit);
        return produitService.save(produit);
    }

    @PostMapping("/{productId}/{stock}/magasin/{magasinId}")
    public int affectToMagasin(@PathVariable Long magasinId, @PathVariable Long productId, @PathVariable int stock) {
        Magasin magasin = new Magasin(magasinId);
        Produit produit = new Produit(productId);
      return produitService.affectToMagasin(magasin, produit, stock);

    }

    @GetMapping("/{id}")
    public Produit findById(@PathVariable Long id) {
        return produitService.findById(id);
    }

    ;

}
