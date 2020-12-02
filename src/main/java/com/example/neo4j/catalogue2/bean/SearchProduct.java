package com.example.neo4j.catalogue2.bean;

import java.util.List;

public class SearchProduct {
    public String magasinId;
    public String categorie;
    public List<String> marques;
    public int priceMin;
    public int  priceMax;

    @Override
    public String toString() {
        return "SearchProduct{" +
                "magasinId='" + magasinId + '\'' +
                ", categorie='" + categorie + '\'' +
                ", marques='" + marques + '\'' +
                ", priceMin='" + priceMin + '\'' +
                ", priceMax='" + priceMax + '\'' +
                '}';
    }
}
