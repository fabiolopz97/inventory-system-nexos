/**
 * 
 */
package com.nexos.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Soluciones
 *
 */
@Entity
@Table(name="positions")
public class Position {
	
	@Id
	private Long id;
	private String name;
	private Date createdAt;
	
}
