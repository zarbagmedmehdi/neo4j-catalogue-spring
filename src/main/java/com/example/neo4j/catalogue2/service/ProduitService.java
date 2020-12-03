package com.example.neo4j.catalogue2.service;

import com.example.neo4j.catalogue2.bean.Magasin;
import com.example.neo4j.catalogue2.bean.Produit;
import com.example.neo4j.catalogue2.bean.SearchProduct;
import com.example.neo4j.catalogue2.bean.StockProduit;
import com.example.neo4j.catalogue2.dao.MagasinRepository;
import com.example.neo4j.catalogue2.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService {
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    MagasinRepository magasinRepository;

    public List<Produit> findAll() {
        return (List<Produit>) produitRepository.findAll();
    }

    public int save(Produit produit){
        if (produit!=null){
            produitRepository.save(produit);
            return 1;
        }
        return -1;
    }

    public int affectToMagasin(Magasin magasin,Produit produit,int stock){

        magasin=magasinRepository.findById(magasin.getId()).get();
        produit=produitRepository.findById(produit.getId()).get();

        StockProduit stockProduit=new StockProduit(stock,magasin, produit);
        List<StockProduit> sp=new ArrayList<>();
        sp.add(stockProduit);
        magasin.setStockProduits(sp);
        produit.setStockProduits(sp);

        magasinRepository.save(magasin);
        produitRepository.save(produit);
        return 1;
    }

    public Produit findById(Long id) {
        Produit produit=produitRepository.findById(id).get();

        return produit;
    }
    public List<String> findAllMarque(){
       return produitRepository.findAllMarques();
    }
    public Iterable<Produit> findByLibelle(String libelle) {
        return  produitRepository.findByReference(libelle);
    }
    public Iterable<Produit> findByCriteria(SearchProduct s){
        return  produitRepository.findCriteria(s.priceMin,s.priceMax,s.marques,s.categorie,s.magasinId);

    }
}
