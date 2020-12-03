package com.example.neo4j.catalogue2.service;

import com.example.neo4j.catalogue2.bean.Client;
import com.example.neo4j.catalogue2.bean.Commande;
import com.example.neo4j.catalogue2.bean.CommandeItem;
import com.example.neo4j.catalogue2.bean.Produit;
import com.example.neo4j.catalogue2.bean.StockProduit;
import com.example.neo4j.catalogue2.dao.ClientRepository;
import com.example.neo4j.catalogue2.dao.CommadeRepository;
import com.example.neo4j.catalogue2.dao.ProduitRepository;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {
    @Autowired
    CommadeRepository commadeRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    ClientRepository clientRepository;
	public int save(Commande commande) {
		if(commande != null && commande.getClient().getId() !=null ) {
			Commande cmd=new Commande();
			TimeZone tz = TimeZone.getTimeZone("UTC");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			df.setTimeZone(tz);
			cmd.setDateCommande(df.format(new Date()));
			cmd.setClient(clientRepository.findById(commande.getClient().getId()).get());
			for(CommandeItem items : commande.getCommandeItems()) {
				if(items.getProduit().getId() != null && items.getQte() > 0){
					Produit produit= produitRepository.findById(items.getProduit().getId()).get();
					CommandeItem item= new CommandeItem(items.getQte(),cmd,produit);
					if(produit.getCommandeItems() == null) {
						List <CommandeItem> list =new ArrayList<CommandeItem>();
						list.add(item);
						produit.setCommandeItems(list);}
					else produit.getCommandeItems().add(item);
					if(cmd.getCommandeItems() == null) {
						List <CommandeItem> list =new ArrayList<CommandeItem>();
						list.add(item);
						cmd.setCommandeItems(list);}
					cmd.getCommandeItems().add(item);
					produitRepository.save(produit);

				}
				else
					return -2;
			}
			commadeRepository.save(cmd);
			return 1;
		}
		else 
			return -1;
	}
	public List<Commande> findByClient (Client client){
		return commadeRepository.getBytClient(client.getId());
	}
     
}
