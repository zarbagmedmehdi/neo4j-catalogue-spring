package com.example.neo4j.catalogue2.service;

import com.example.neo4j.catalogue2.dao.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
}
