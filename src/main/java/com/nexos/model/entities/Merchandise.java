/**
 * 
 */
package com.nexos.model.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Soluciones
 * Class that represents an entity from the merchandise table.
 */
@Entity
public class Merchandise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMerchandise;
	@Column(length = 100)
	private String nameProduct;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	private Date admissionDate;
	private LocalDateTime createdAt;

	/**
	 * @return the idMerchandise
	 */
	public int getIdMerchandise() {
		return idMerchandise;
	}

	/**
	 * @param idMerchandise the idMerchandise to set
	 */
	public void setIdMerchandise(int idMerchandise) {
		this.idMerchandise = idMerchandise;
	}

	/**
	 * @return the nameProduct
	 */
	public String getNameProduct() {
		return nameProduct;
	}

	/**
	 * @param nameProduct the nameProduct to set
	 */
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	 * @return the admissionDate
	 */
	public Date getAdmissionDate() {
		return admissionDate;
	}

	/**
	 * @param admissionDate the admissionDate to set
	 */
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
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
