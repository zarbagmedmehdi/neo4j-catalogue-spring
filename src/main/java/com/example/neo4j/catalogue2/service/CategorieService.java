package com.example.neo4j.catalogue2.service;

import com.example.neo4j.catalogue2.bean.Categorie;
import com.example.neo4j.catalogue2.dao.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    public int save(Categorie categorie){
        if(categorie!=null){
            categorieRepository.save(categorie);
            return 1;
        }
        return -1;
    }

    //Mehdi Work
    public Iterable<Categorie> findAll(){
        return categorieRepository.findAll();
    }
}
