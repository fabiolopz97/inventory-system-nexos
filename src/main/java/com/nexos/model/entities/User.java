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
@Table(name="users")
public class User {
	
	@Id
	private Long id;
	private String name;
	private int age;
	private String position;
	private Date admissionDate;
	private Date createdAt;

}
