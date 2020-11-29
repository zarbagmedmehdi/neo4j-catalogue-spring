package com.example.neo4j.catalogue2.bean;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@NodeEntity
public class Produit {
    @Id
    @GeneratedValue
    private Long id;
    private String reference;
    private String libelle;
    private Double prix;
    private String marque;
    private String image;
    private String description;
    //private Map<String, String> caracteristiques;

//    @Relationship(type = "STOCKED_IN", direction = INCOMING)
//    private List<StockProduit> stockProduits = new ArrayList<>();


    public Produit(Long id) {
        this.id = id;
    }

    public Produit withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            return new Produit(id);
        }
    }
//    @Relationship(type = "IN_CATEGORY", direction = INCOMING)
//    private List<Categorie> categories;
//    @Relationship(type = "IN_MAGASIN", direction = INCOMING)
//    private List<Magasin> magasins;
//    @Relationship(type = "HAS_REVIEW", direction = INCOMING)
//    private List<Review> reviews;
//    @Relationship(type = "ORDRED_IN", direction = INCOMING)
//    private List<Commande> commandes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
