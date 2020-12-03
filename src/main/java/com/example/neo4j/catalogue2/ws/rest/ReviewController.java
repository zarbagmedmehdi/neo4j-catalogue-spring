package com.example.neo4j.catalogue2.ws.rest;

import com.example.neo4j.catalogue2.bean.Client;
import com.example.neo4j.catalogue2.bean.Produit;
import com.example.neo4j.catalogue2.bean.Review;
import com.example.neo4j.catalogue2.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping("/")
    public int save(@RequestBody Review review) {

        return reviewService.save(review);
    }

    @GetMapping("client/{clientId}/{reviewId}/{productId}/")
    public int reviewOfProduct(@PathVariable Long clientId, @PathVariable Long productId, @PathVariable Long reviewId) {
        Client client = new Client(clientId);
        Review review = new Review(reviewId);
        Produit produit = new Produit(productId);
        return reviewService.reviewOfProduct(produit, client, review);

    }

    @GetMapping("/prodlib/{libelle}")
    public List<Review> getReviewsOfProduct(@PathVariable String libelle) {
        return reviewService.getReviewsOfProduct(libelle);
    }
}
