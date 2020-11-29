package com.example.neo4j.catalogue2.dao;

import com.example.neo4j.catalogue2.bean.Magasin;
import com.example.neo4j.catalogue2.bean.Produit;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProduitRepository extends Neo4jRepository<Produit,Long> {

}
