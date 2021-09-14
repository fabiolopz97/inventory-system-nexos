/**
 * 
 */
package com.nexos.model.entities;

import java.util.Date;

import javax.persistence.Entity;

/**
 * @author Soluciones
 *
 */
@Entity
public class Merchandise {
	
	private Long id;
	private String name;
	private String product;
	private int quantity;
	private User user;
	private Date admissionDate;
	private Date createdAt;

}
