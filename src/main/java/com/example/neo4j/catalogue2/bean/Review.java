package com.example.neo4j.catalogue2.bean;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private int stars;
    private String comment;

    @Relationship(type = "WRITTEN_BY")
    private Client client;

    public Review() {
    }

    public Review(int stars, String comment, Client client) {
        this.stars = stars;
        this.comment = comment;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
