package com.example.neo4j.catalogue2.dao;

import com.example.neo4j.catalogue2.bean.Review;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends Neo4jRepository<Review,Long> {
    @Query("Match (re:Review)<-[:HAS_REVIEW]-(p:Produit) WHERE p.libelle=$libelle RETURN re LIMIT 25")
    List<Review> getReviewsOfProduct(String libelle);
}
