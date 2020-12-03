package com.example.neo4j.catalogue2.dao;

import com.example.neo4j.catalogue2.bean.Client;
import com.example.neo4j.catalogue2.bean.Commande;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommadeRepository extends Neo4jRepository<Commande,Long> {


    @Query("MATCH (cl:Client)-[r:ORDERS]->(c:Commande)  where id(cl)=$id return c")
    public List<Commande> getBytClient(long id);

}
