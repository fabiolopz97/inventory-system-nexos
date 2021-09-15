/**
 * 
 */
package com.nexos.model.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Soluciones
 * Class that represents an entity from the maintenance_merchandise table.
 */
@Entity
public class MaintenanceMerchandise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMaintenanceMerchandise;
	@ManyToOne
	@JoinColumn(name = "idMerchandise")
	private Merchandise merchandise;
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	private LocalDateTime createdAt;

	/**
	 * @return the idMaintenanceMerchandise
	 */
	public int getIdMaintenanceMerchandise() {
		return idMaintenanceMerchandise;
	}

	/**
	 * @param idMaintenanceMerchandise the idMaintenanceMerchandise to set
	 */
	public void setId(int idMaintenanceMerchandise) {
		this.idMaintenanceMerchandise = idMaintenanceMerchandise;
	}

	/**
	 * @return the merchandise
	 */
	public Merchandise getMerchandise() {
		return merchandise;
	}

	/**
	 * @param merchandise the merchandise to set
	 */
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
