package com.nexos.model.dto;

/**
 * @author Soluciones
 *
 */
public class UserDto {
	private int id;
	private String userName;
	
	/**
	 * @param id
	 * @param userName
	 */
	public UserDto(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	
	
}
