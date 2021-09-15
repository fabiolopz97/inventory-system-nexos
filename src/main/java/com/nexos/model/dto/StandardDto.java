/**
 * 
 */
package com.nexos.model.dto;

/**
 * @author Soluciones
 *
 */
public class StandardDto {

	private String result;
	private boolean error;
	private String message;

	/**
	 * @param result
	 * @param error
	 * @param message
	 */
	public StandardDto(String result, boolean error, String message) {
		super();
		this.result = result;
		this.error = error;
		this.message = message;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the error
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
