package com.example.neo4j.catalogue2.bean;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Magasin {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String adresse;
    private String ville;

    @Relationship(type = "STOCKED_IN",direction = Relationship.INCOMING)
    private List<StockProduit> stockProduits=new ArrayList<>();

    public Magasin() {
    }

    public Magasin(Long id, String nom, String adresse, String ville) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
    }

    public Magasin(Long id) {
        this.id = id;
    }

    public Magasin withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            return new Magasin(id, this.nom,this.adresse,this.ville);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<StockProduit> getStockProduits() {
        return stockProduits;
    }

    public void setStockProduits(List<StockProduit> stockProduits) {
        this.stockProduits = stockProduits;
    }

    @Override
    public String toString() {
        return "Magasin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
