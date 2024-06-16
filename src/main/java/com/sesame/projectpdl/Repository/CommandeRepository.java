package com.sesame.projectpdl.Repository;

import com.sesame.projectpdl.Entity.Commande;
import com.sesame.projectpdl.Entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CommandeRepository extends JpaRepository <Commande, Long> {
}

