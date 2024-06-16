package com.sesame.projectpdl.Services;

import com.sesame.projectpdl.Dto.CommandeItemDto;
import com.sesame.projectpdl.Entity.Commande;
import com.sesame.projectpdl.Entity.CommandeItem;
import com.sesame.projectpdl.Entity.Product;
import com.sesame.projectpdl.Entity.User;
import com.sesame.projectpdl.Repository.CommandeItemRepository;
import com.sesame.projectpdl.Repository.CommandeRepository;
import com.sesame.projectpdl.Repository.ProductRepository;
import com.sesame.projectpdl.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeServicesImpl implements ICommnadeServices{

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CommandeItemRepository commandeItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Commande creatCommande(String name, List<CommandeItem> commandeItemsDtos) {
        User user = userRepository.findByname(name);

        Commande commande = new Commande();
        commande.setDate(LocalDateTime.now());
        commande.setUser(user);
        commande = commandeRepository.save(commande);

        for (CommandeItemDto itemDto : commandeItemsDtos) {
            Product product = productRepository.findById(itemDto.getId()).orElseThrow(()-> new IllegalArgumentException("Product not found"));
            CommandeItem commandeItem = new CommandeItem();
            commandeItem.setProduct(product);
            commandeItem.setCommande(commande);
            commandeItem.setQte(itemDto.getQte());
            commandeItemRepository.save(commandeItem);     }

        return commande;
    }

    @Transactional
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Commande updatedCommande) {
        Optional<Commande> existingCommandeOptional = commandeRepository.findById(updatedCommande.getId());

        if (existingCommandeOptional.isPresent()) {
            Commande existingCommande = existingCommandeOptional.get();
            existingCommande.setDate(updatedCommande.getDate());
            // Mettre à jour d'autres propriétés selon les besoins

            return commandeRepository.save(existingCommande);
        }

        return null;
    }

    @Override
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}