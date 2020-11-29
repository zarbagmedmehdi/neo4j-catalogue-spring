package com.example.neo4j.catalogue2.bean;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

//@NodeEntity
public class Categorie {
//    @Id
//    @GeneratedValue
    private Long id;
    private String libelle;

  // @Relationship(type = "IN_CATEGORY")
    private List<Produit> produits;

}
