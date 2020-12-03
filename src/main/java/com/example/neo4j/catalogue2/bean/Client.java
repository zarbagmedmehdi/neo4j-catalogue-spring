package com.example.neo4j.catalogue2.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.swing.text.StyledEditorKit;
import java.util.List;

@NodeEntity
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String numTel;
    private String adresse;
    private boolean isAdmin;
    @JsonIgnore
    @Relationship(type = "ORDERS")
    private List<Commande> commandes;

    @Relationship(type= "WRITTEN_BY",direction = Relationship.INCOMING)
    private Review  reviews;

    public Client() {
    }

    public Client(Long id) {
        this.id = id;
    }


    public Client(String nom, String prenom, String email, String password, String numTel, String adresse, boolean cc) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.adresse = adresse;
        this.isAdmin=cc;
    }

    public Client(String nom, String email, String password, boolean isAdmin) {
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    public Review getReviews() {
        return reviews;
    }

    public void setReviews(Review reviews) {
        this.reviews = reviews;
    }
    public boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", numTel='" + numTel + '\'' +
                ", adresse='" + adresse + '\'' +
                ", isAdmin=" + isAdmin +
                ", commandes=" + commandes +
                '}';
    }
}
