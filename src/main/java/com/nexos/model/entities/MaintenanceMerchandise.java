/**
 * 
 */
package com.nexos.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Soluciones
 *
 */
@Entity
public class MaintenanceMerchandise {

	@Id
	private Long id;
	private User user;
	private Date createdAt;

}
