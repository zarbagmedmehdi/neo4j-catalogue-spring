package com.example.neo4j.catalogue2.service;

import com.example.neo4j.catalogue2.bean.Magasin;
import com.example.neo4j.catalogue2.bean.Produit;
import com.example.neo4j.catalogue2.bean.StockProduit;
import com.example.neo4j.catalogue2.dao.MagasinRepository;
import com.example.neo4j.catalogue2.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    MagasinRepository magasinRepository;
//    @Autowired
//    CategorieRepository categorieRepository;

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
        magasin.getStockProduits().add(stockProduit);
        produit.getStockProduits().add(stockProduit);

        magasinRepository.save(magasin);
        produitRepository.save(produit);
        return 1;
    }

    public Produit findById(Long id) {
        Produit produit=produitRepository.findById(id).get();
        for (StockProduit stockProduit:produit.getStockProduits()
             ) {
            System.out.println(stockProduit);
        }
        return produit;
    }

    public List<Produit> findAll() {
        return (List<Produit>) produitRepository.findAll();
    }
}
