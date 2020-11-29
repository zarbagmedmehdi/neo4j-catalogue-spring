package com.example.neo4j.catalogue2.bean;

import java.util.List;

public class Commande {
    private Long id;
    private String nom;
    private String dateCommande;

    private Client client;
    private List<Produit> produits;
}
