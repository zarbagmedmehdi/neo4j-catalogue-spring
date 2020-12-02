package com.example.neo4j.catalogue2.util;

import com.example.neo4j.catalogue2.bean.SearchProduct;

public class QueryUtil {

   /* public static String findByCriteria(SearchProduct s){
        String req="MATCH (p :Produit) where 1=1 ";

        if (s.priceMax != null && !s.priceMax.equals("null")) {
            req+="and p.prix<"+s.priceMax+" ";
        }

        if (s.priceMin != null && !s.priceMin.equals("null")) {
            req+="and p.prix>"+s.priceMin+" ";
        }
        req+="return p;";

        return req;
    }

    */
}
