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
    private String id;
    private String reference;
    private String libelle;
    private Double prix;
    private String marque;
    private String image;
    private String description;
    //private Map<String, String> caracteristiques;

    @Relationship(type = "STOCKED_IN", direction = INCOMING)
    private List<StockProduit> stockProduits = new ArrayList<>();

//    @Relationship(type = "IN_CATEGORY", direction = INCOMING)
//    private List<Categorie> categories;
//    @Relationship(type = "IN_MAGASIN", direction = INCOMING)
//    private List<Magasin> magasins;
//    @Relationship(type = "HAS_REVIEW", direction = INCOMING)
//    private List<Review> reviews;
//    @Relationship(type = "ORDRED_IN", direction = INCOMING)
//    private List<Commande> commandes;
}
