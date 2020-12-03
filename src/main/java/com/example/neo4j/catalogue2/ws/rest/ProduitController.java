package com.example.neo4j.catalogue2.ws.rest;

import com.example.neo4j.catalogue2.bean.Magasin;
import com.example.neo4j.catalogue2.bean.Produit;
import com.example.neo4j.catalogue2.bean.SearchProduct;
import com.example.neo4j.catalogue2.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    ProduitService produitService;


    @GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Produit produit) {
        System.out.println(produit);
        return produitService.save(produit);
    }

    @GetMapping("/{productId}/{stock}/magasin/{magasinId}")
    public int affectToMagasin(@PathVariable Long magasinId, @PathVariable Long productId, @PathVariable int stock) {
        Magasin magasin = new Magasin(magasinId);
        Produit produit = new Produit(productId);
        return produitService.affectToMagasin(magasin, produit, stock);

    }

    @GetMapping("/{id}")
    public Produit findById(@PathVariable Long id) {
        return produitService.findById(id);
    }
    @GetMapping("/libelle/{libelle}")
    public Iterable<Produit> findByLibelle(@PathVariable String libelle)

    {
        System.out.println(libelle);
        if(libelle==null) return produitService.findAll();
        return produitService.findByLibelle(libelle);
    }
    @GetMapping("/marques")
    public List<String> findAllMarques() {
        return produitService.findAllMarque();
    }
    @PostMapping("/criteria")
    public Iterable<Produit> findByCriteria(@RequestBody SearchProduct s)

    {
        return produitService.findByCriteria(s);
    }

}
