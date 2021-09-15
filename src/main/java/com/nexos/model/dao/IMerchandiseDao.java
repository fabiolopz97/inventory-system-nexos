package com.nexos.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexos.model.entities.Merchandise;

/**
 * 
 * @author Soluciones
 *
 */
public interface IMerchandiseDao extends JpaRepository<Merchandise, Integer> {
	Optional<Merchandise> findByNameProduct(String name);
}
