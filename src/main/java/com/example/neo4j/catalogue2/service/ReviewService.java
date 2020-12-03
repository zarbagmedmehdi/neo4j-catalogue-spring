package com.example.neo4j.catalogue2.service;

import com.example.neo4j.catalogue2.bean.Client;
import com.example.neo4j.catalogue2.bean.Produit;
import com.example.neo4j.catalogue2.bean.Review;
import com.example.neo4j.catalogue2.dao.ClientRepository;
import com.example.neo4j.catalogue2.dao.ProduitRepository;
import com.example.neo4j.catalogue2.dao.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    ClientRepository clientRepository;


    public int save(Review review){
        if (review!=null) {
            reviewRepository.save(review);

        }
        return 1;

    }
    public List<Review> getReviewsOfProduct(String libelle) {
        Client client = new Client();
        Review r=new Review();

        List<Review> rev = new ArrayList<>();
        List<Review> rev2 = new ArrayList<>();
        rev = reviewRepository.getReviewsOfProduct(libelle);
        if(rev==null){
            return null;
        }

        for(Review view:rev){
            List<Client> cls = new ArrayList<>();
            client = clientRepository.searchComment(view.getComment());
            cls.add(client);
            r=view;
            r.setClient(client);
            rev2.add(r);

        }

        return rev2;
    }

    public int reviewOfProduct(Produit produit, Client client, Review review){
        review.setProduit(produitRepository.findById(produit.getId()).get());
        client.setReviews(reviewRepository.findById(review.getId()).get());

        if (review!=null){
            reviewRepository.save(review);
            clientRepository.save(client);
            return 1;
        }
        return -1;
    }

    public Review findById(Long id) {
        Review review=reviewRepository.findById(id).get();

        return review;
    }

}
