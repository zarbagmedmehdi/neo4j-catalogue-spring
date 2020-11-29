package com.example.neo4j.catalogue2.bean;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

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

    @Relationship(type = "STOCKED_IN")
    private List<StockProduit> stockProduits=new ArrayList<>();
}
