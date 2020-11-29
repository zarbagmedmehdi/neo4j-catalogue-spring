package com.example.neo4j.catalogue2.bean;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Magasin {
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private String adresse;
    private String ville;

//    @Relationship(type = "STOCKED_IN")
//    private List<StockProduit> stockProduits=new ArrayList<>();

    public Magasin() {
    }

    public Magasin(Long id, String nom, String adresse, String ville) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
    }

    public Magasin withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            return new Magasin(id, this.nom,this.adresse,this.ville);
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

//    public List<StockProduit> getStockProduits() {
//        return stockProduits;
//    }
//
//    public void setStockProduits(List<StockProduit> stockProduits) {
//        this.stockProduits = stockProduits;
//    }
}
