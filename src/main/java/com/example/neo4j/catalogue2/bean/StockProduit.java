package com.example.neo4j.catalogue2.bean;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@RelationshipEntity(type = "STOCKED_IN")
public class StockProduit {
    @Id
    @GeneratedValue
    private String id;
    private int stock;

    @StartNode
    private Magasin magasin;
    @EndNode
    private Produit produit;
}
