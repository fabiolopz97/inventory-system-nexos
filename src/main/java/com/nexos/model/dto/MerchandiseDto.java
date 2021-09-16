/**
 * 
 */
package com.nexos.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Soluciones
 *
 */
public class MerchandiseDto {

	private int id;
	private String nameProduct;
	private int quantity;
	private int userId;
	private String userName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date admissionDate;
	
	/**
	 * 
	 */
	public MerchandiseDto() {
		super();
	}

	/**
	 * @param id
	 * @param nameProduct
	 * @param quantity
	 * @param userName
	 * @param admissionDate
	 */
	public MerchandiseDto(int id, String nameProduct, int quantity, int userId, String userName, Date admissionDate) {
		super();
		this.id = id;
		this.nameProduct = nameProduct;
		this.quantity = quantity;
		this.userId = userId;
		this.userName = userName;
		this.admissionDate = admissionDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

}
