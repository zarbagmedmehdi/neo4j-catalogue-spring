package com.example.neo4j.catalogue2.service;

import com.example.neo4j.catalogue2.bean.Categorie;
import com.example.neo4j.catalogue2.dao.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Categorie> findAll() {
        return (List<Categorie>) categorieRepository.findAll();
    }
}
