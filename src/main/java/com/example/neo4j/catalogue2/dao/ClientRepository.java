package com.example.neo4j.catalogue2.dao;

import com.example.neo4j.catalogue2.bean.Client;

import java.util.Optional;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends Neo4jRepository<Client,Long> {

    public Client findByEmailAndPassword(String email, String password);
    public Client findById(long id);

    @Query("Match (c:Client)<-[r:WRITTEN_BY]-(re:Review) WHERE re.comment=$comment return c")
    Client searchComment(String comment);
}
