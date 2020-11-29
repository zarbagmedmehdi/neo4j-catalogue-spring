package com.example.neo4j.catalogue2.dao;

import com.example.neo4j.catalogue2.bean.Magasin;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagasinRepository extends Neo4jRepository<Magasin,Long> {

}
