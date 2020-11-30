package com.example.neo4j.catalogue2.bean;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "CONTAINS")
public class CommandeItem {
    @Id
    @GeneratedValue
    private Long id;
    private int qte;

    @StartNode
    private Commande commande;
    @EndNode
    private Produit produit;

    public CommandeItem() {
    }

    public CommandeItem(int qte, Commande commande, Produit produit) {
        this.qte = qte;
        this.commande = commande;
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "CommandeItem{" +
                "id=" + id +
                ", qte=" + qte +
                '}';
    }
}
