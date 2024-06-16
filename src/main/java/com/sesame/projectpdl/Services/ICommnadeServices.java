package com.sesame.projectpdl.Services;

import com.sesame.projectpdl.Entity.Commande;
import com.sesame.projectpdl.Entity.CommandeItem;

import java.util.List;

public interface ICommnadeServices {
    public Commande creatCommande(String name, List<CommandeItem> commandeItemsDtos);
    public List<Commande> getAllCommandes();
    public Commande getCommandeById(Long id);
    public Commande createCommande(Commande commande);
    public Commande updateCommande(Commande updatedCommande);
    public void deleteCommande(Long id);


}
