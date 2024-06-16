package com.sesame.projectpdl.Repository;

import com.sesame.projectpdl.Entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeItemRepository extends JpaRepository<CommandeItem, Long> {
}