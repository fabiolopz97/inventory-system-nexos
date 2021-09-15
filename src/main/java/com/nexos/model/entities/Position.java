/**
 * 
 */
package com.nexos.model.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Soluciones
 * Class that represents an entity from the positions table.
 */
@Entity
@Table(name = "positions")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPosition;
	@Column(length = 50)
	private String name;
	private LocalDateTime createdAt;

	/**
	 * @return the idPosition
	 */
	public int getIdPosition() {
		return idPosition;
	}

	/**
	 * @param idPosition the idPosition to set
	 */
	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
