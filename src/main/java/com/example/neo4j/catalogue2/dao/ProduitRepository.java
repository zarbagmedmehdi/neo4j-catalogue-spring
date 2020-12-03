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
    public Iterable<Produit> findByReference(String reference);





    @Query("MATCH (p :Produit) WHERE EXISTS(p.marque) RETURN DISTINCT p.marque AS marque LIMIT 25")
    public List<String> findAllMarques();



    @Query("MATCH (c:Categorie)<-[r:IN_CATEGORY]-(p:Produit)-[d:STOCKED_IN]->(m:Magasin) WHERE "
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
            +" END AND "
            +" CASE WHEN  $categorie IS NOT  NULL "
            +" THEN c.libelle=  $categorie"
            +" ELSE TRUE "
            +" END AND "
            +" CASE WHEN NOT $magasin=0 "
            +" THEN id(m)=$magasin"
            +" ELSE TRUE "
            +" END"
            +" Return p"
            +""
            +""
    )
    public Iterable<Produit> findCriteria( int pmin,int pmax,List<String> marques,String categorie,int magasin);

}
