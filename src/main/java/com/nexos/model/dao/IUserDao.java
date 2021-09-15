/**
 * 
 */
package com.nexos.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexos.model.entities.User;

/**
 * @author Soluciones
 *
 */
public interface IUserDao extends JpaRepository<User, Integer> {

}
