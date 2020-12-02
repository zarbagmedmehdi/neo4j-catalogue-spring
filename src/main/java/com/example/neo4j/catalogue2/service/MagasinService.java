package com.example.neo4j.catalogue2.service;

import com.example.neo4j.catalogue2.bean.Magasin;
import com.example.neo4j.catalogue2.dao.MagasinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MagasinService {
    @Autowired
    MagasinRepository magasinRepository;
    public int save(Magasin magasin) {
        if (magasin!=null){
            magasinRepository.save(magasin);
            return 1;
        }
        return -1;
    }

    public MagasinService(MagasinRepository magasinRepository) {
        this.magasinRepository = magasinRepository;
    }

//Mehdi work
    public Iterable<Magasin> findAll(){
        return magasinRepository.findAll();
    }
}
