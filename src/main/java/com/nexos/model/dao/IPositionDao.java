/**
 * 
 */
package com.nexos.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexos.model.entities.Position;

/**
 * @author Soluciones
 *
 */
public interface IPositionDao extends JpaRepository<Position, Integer> {

}
