package com.sesame.projectpdl.Controller;

import com.sesame.projectpdl.Entity.Commande;
import com.sesame.projectpdl.Entity.CommandeItem;
import com.sesame.projectpdl.Services.CommandeServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeServicesImpl commandeServices;

    @PostMapping("/createcommande")
    public Commande createcommande(@RequestBody List<CommandeItem> commandeItemDtos) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return commandeServices.creatCommande(name,commandeItemDtos);
    }
    @GetMapping("/getallcommandes")
    public List<Commande> getAllCommandes() {
        return commandeServices.getAllCommandes();
    }
    @GetMapping("/getcomandeby/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeServices.getCommandeById(id);
    }
    @PostMapping("/ajoutercommande")
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeServices.createCommande(commande);
    }
    @PutMapping("/updatecommande/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        commande.setId(id);
        return commandeServices.updateCommande(commande);
    }
    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeServices.deleteCommande(id);
    }
}
