/**
 * 
 */
package com.nexos.model.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.model.dao.IMaintenanceMerchandiseDao;
import com.nexos.model.dao.IMerchandiseDao;
import com.nexos.model.dto.StandardDto;
import com.nexos.model.entities.MaintenanceMerchandise;
import com.nexos.model.entities.Merchandise;

/**
 * @author Soluciones
 *
 */
@Service
public class MerchandiseService implements IMerchandiseService {

	@Autowired
	private IMerchandiseDao merchandiseDao;
	
	@Autowired
	private IMaintenanceMerchandiseDao maintenanceMerchandiseDao;

	/**
	 * Method to get all the merchandise
	 * 
	 * @return
	 */
	@Override
	public List<Merchandise> getAllMerchandise() {
		return merchandiseDao.findAll();
	}

	/**
	 * Method to store the merchandise without repeating it by name.
	 */
	@Override
	public Merchandise saveMerchandise(Merchandise merchandise) {
		Merchandise resultMerchandise = null;
		Optional<Merchandise> optMerchandise = merchandiseDao.findByNameProduct(merchandise.getNameProduct());
		if (!optMerchandise.isPresent()) {
			merchandise.setCreatedAt(LocalDateTime.now());
			resultMerchandise = merchandiseDao.save(merchandise);
		}
		return resultMerchandise;
	}

	/**
	 * Method to delete merchandise
	 * 
	 */
	@Override
	public void deleteMerchandise(Merchandise merchandise) {
		merchandiseDao.delete(merchandise);
	}
	
	/**
	 * Method to get merchandise by merchandiseId
	 * 
	 * @return
	 */
	@Override
	public Optional <Merchandise> findById(int merchandiseId) {
		Optional <Merchandise> optMerchandise = merchandiseDao.findById(merchandiseId);
		return optMerchandise;
	}
	
	/**
	 * Method to update merchandise
	 */
	@Override
	public StandardDto updateMerchandise(Merchandise merchandise, Merchandise merchandiseRequest) {
		
		StandardDto standardDto = null;
		if (!merchandiseRequest.getNameProduct().equals(merchandise.getNameProduct())) {
			Optional<Merchandise> optMerchandise = merchandiseDao
					.findByNameProduct(merchandiseRequest.getNameProduct());
			
			if (!optMerchandise.isPresent()) {
				merchandise.setNameProduct(merchandiseRequest.getNameProduct());
			} else {
				// Error if exists
				standardDto = new StandardDto("NOT OK", true, "Error the product name already exists.");
			}
		}
		if (standardDto == null) {
			merchandise.setQuantity(merchandiseRequest.getQuantity());
			merchandiseDao.save(merchandise);
			
			MaintenanceMerchandise maintenanceMerchandise = new MaintenanceMerchandise();
			maintenanceMerchandise.setMerchandise(merchandise);
			maintenanceMerchandise.setUser(merchandiseRequest.getUser());
			maintenanceMerchandise.setCreatedAt(LocalDateTime.now());
			maintenanceMerchandiseDao.save(maintenanceMerchandise);
			standardDto = new StandardDto("OK", false, "The registry has been successfully updated!");
		}
		return standardDto;
	}

}
