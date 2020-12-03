package com.example.neo4j.catalogue2.bean;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Properties
    private Map<String, String> caracteristiques;
    @JsonIgnore
    @Relationship(type = "STOCKED_IN")
    private List<StockProduit> stockProduits = new ArrayList<>();
    @Relationship(type = "IN_CATEGORY")
    private List<Categorie> categories;
    @JsonIgnore
    @Relationship(type = "CONTAINS", direction = Relationship.INCOMING)
    private List<CommandeItem> commandeItems;
    @Relationship(type = "HAS_REVIEW")
    private List<Review> reviews;


    public Produit() {
    }

    public Produit(Long id) {
        this.id = id;
    }

    public Produit(String reference, String libelle, Double prix, String marque, String image, String description) {

        this.reference = reference;
        this.libelle = libelle;
        this.prix = prix;
        this.marque = marque;
        this.image = image;
        this.description = description;
    }


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

    @JsonAnyGetter
    public Map<String, String> getCaracteristiques() {
        return caracteristiques;
    }

    @JsonAnySetter
    public void setCaracteristiques(Map<String, String> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public List<StockProduit> getStockProduits() {
        return stockProduits;
    }

    public void setStockProduits(List<StockProduit> stockProduits) {
        this.stockProduits = stockProduits;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", libelle='" + libelle + '\'' +
                ", prix=" + prix +
                ", marque='" + marque + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", caracteristiques=" + caracteristiques +
                ", stockProduits=" + stockProduits +
                ", categories=" + categories +
                '}';
    }
}
