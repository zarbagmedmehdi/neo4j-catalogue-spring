package com.example.neo4j.catalogue2.bean;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@NodeEntity
public class Commande {
    @Id
    @GeneratedValue
    private Long id;
    private String dateCommande;

    @Relationship(type = "ORDERED_BY",direction = Relationship.INCOMING)
    private Client client;
    @Relationship(type = "CONTAINS")
    private List<CommandeItem> commandeItems;

    public Commande() {
    }

    public Commande(String dateCommande, Client client, List<CommandeItem> commandeItems) {
        this.dateCommande = dateCommande;
        this.client = client;
        this.commandeItems = commandeItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", dateCommande='" + dateCommande + '\'' +
                '}';
    }
}
