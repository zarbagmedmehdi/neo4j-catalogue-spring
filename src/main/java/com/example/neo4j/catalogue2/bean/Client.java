package com.example.neo4j.catalogue2.bean;

import java.util.List;

public class Client {
    private Long id;
    private String nom;
    private String prenom;
    private String numTel;
    private String adresse;

    private List<Commande> commandes;
}
