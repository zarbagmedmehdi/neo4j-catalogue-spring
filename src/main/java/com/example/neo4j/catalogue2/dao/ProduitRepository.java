package com.example.neo4j.catalogue2.dao;

import com.example.neo4j.catalogue2.bean.Produit;
import com.example.neo4j.catalogue2.bean.SearchProduct;
import com.example.neo4j.catalogue2.util.QueryUtil;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends Neo4jRepository<Produit,Long>  {
    public static SearchProduct formData=new SearchProduct();
    public Produit findByReference(String reference);



    //Mehdi work
    public Iterable<Produit>  findByLibelle(String libelle);

    @Query("MATCH (p :Produit) WHERE EXISTS(p.marque) RETURN DISTINCT p.marque AS marque LIMIT 25")
    public List<String> findAllMarques();



    @Query("MATCH (p :Produit) WHERE "
    +"  CASE WHEN NOT $pmin=0 "
    +"THEN p.prix> $pmin "
            +"ELSE TRUE "
            +"END AND "
            +" CASE WHEN NOT $pmax=0 "
            +" THEN p.prix< $pmax"
            +" ELSE TRUE "
            +" END AND "
            +" CASE WHEN  $marques IS NOT  NULL "
            +" THEN p.marque IN $marques"
            +" ELSE TRUE "
            +" END"
            +" Return p"
            +""
            +""
    )
    public Iterable<Produit> findCriteria( int pmin,int pmax,List<String> marques);

}
