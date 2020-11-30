package com.example.neo4j.catalogue2.dao;

import com.example.neo4j.catalogue2.bean.Review;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends Neo4jRepository<Review,Long> {
}
