/**
 * 
 */
package com.nexos.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexos.model.entities.MaintenanceMerchandise;

/**
 * @author Soluciones
 *
 */
public interface IMaintenanceMerchandiseDao extends JpaRepository<MaintenanceMerchandise, Integer> {

}
