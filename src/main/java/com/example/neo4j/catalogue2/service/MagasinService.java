package com.example.neo4j.catalogue2.service;

import com.example.neo4j.catalogue2.bean.Magasin;
import com.example.neo4j.catalogue2.dao.MagasinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Magasin> findAll() {
        return (List<Magasin>) magasinRepository.findAll();
    }

    public void deleteById(Long id) {
        magasinRepository.deleteById(id);
    }
}
