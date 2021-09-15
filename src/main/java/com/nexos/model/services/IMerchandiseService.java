/**
 * 
 */
package com.nexos.model.services;

import java.util.List;
import java.util.Optional;

import com.nexos.model.dto.StandardDto;
import com.nexos.model.entities.Merchandise;

/**
 * @author Soluciones
 *
 */
public interface IMerchandiseService {
	
	public List<Merchandise> getAllMerchandise();
	
	public Merchandise saveMerchandise(Merchandise merchandise);
	
	public StandardDto updateMerchandise(Merchandise merchandise, Merchandise merchandiseRequest);
	
	public void deleteMerchandise(Merchandise merchandise);
	
	public Optional <Merchandise> findById(int merchandiseId);
}
