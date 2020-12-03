package com.example.neo4j.catalogue2.bean;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "STOCKED_IN")
public class StockProduit {
    @Id
    @GeneratedValue
    private Long id;
    private int stock;

    @StartNode
    private Produit produit;
    @EndNode
    private Magasin magasin;

    public StockProduit() {
    }

    public StockProduit(int stock, Magasin magasin, Produit produit) {
        this.stock = stock;
        this.magasin = magasin;
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "StockProduit{" +
                "id=" + id +
                ", stock=" + stock +
                ", magasin=" + magasin +
                '}';
    }
}
