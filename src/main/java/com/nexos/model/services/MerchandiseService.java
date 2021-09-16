/**
 * 
 */
package com.nexos.model.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.nexos.model.dao.IMaintenanceMerchandiseDao;
import com.nexos.model.dao.IMerchandiseDao;
import com.nexos.model.dto.MerchandiseDto;
import com.nexos.model.dto.MerchandiseRequestDto;
import com.nexos.model.dto.StandardDto;
import com.nexos.model.entities.MaintenanceMerchandise;
import com.nexos.model.entities.Merchandise;
import com.nexos.model.entities.User;

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
	public List<MerchandiseDto> getAllMerchandise() {
		List<MerchandiseDto> listMerchandise = new ArrayList<>();
		merchandiseDao.findAll(Sort.by("idMerchandise").ascending()).forEach(merchandise -> {
			listMerchandise.add(new MerchandiseDto(merchandise.getIdMerchandise(), merchandise.getNameProduct(),
					merchandise.getQuantity(), merchandise.getUser().getIdUser(), merchandise.getUser().getName(),
					merchandise.getAdmissionDate()));
		});
		return listMerchandise;
	}

	/**
	 * Method to store the merchandise without repeating it by name.
	 */
	@Override
	public MerchandiseDto saveMerchandise(MerchandiseRequestDto merchandiseRequest) {
		Merchandise resultMerchandise = new Merchandise();
		MerchandiseDto merchandiseDto;
		Optional<Merchandise> optMerchandise = merchandiseDao.findByNameProduct(merchandiseRequest.getNameProduct());
		Merchandise merchandise = new Merchandise();
		User user = new User();
		if (!optMerchandise.isPresent()) {
			merchandise.setNameProduct(merchandiseRequest.getNameProduct());
			merchandise.setQuantity(merchandiseRequest.getQuantity());
			merchandise.setAdmissionDate(merchandiseRequest.getAdmissionDate());
			user.setIdUser(merchandiseRequest.getUserId());
			merchandise.setUser(user);
			merchandise.setCreatedAt(LocalDateTime.now());
			resultMerchandise = merchandiseDao.save(merchandise);
			merchandiseDto = new MerchandiseDto(resultMerchandise.getIdMerchandise(),
					resultMerchandise.getNameProduct(), resultMerchandise.getQuantity(),
					resultMerchandise.getUser().getIdUser(), resultMerchandise.getUser().getName(),
					resultMerchandise.getAdmissionDate());

			merchandiseDto.setAdmissionDate(merchandise.getAdmissionDate());
		} else {
			merchandiseDto = new MerchandiseDto();
		}
		return merchandiseDto;
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
	public Optional<Merchandise> findById(int merchandiseId) {
		Optional<Merchandise> optMerchandise = merchandiseDao.findById(merchandiseId);
		return optMerchandise;
	}

	/**
	 * Method to update merchandise
	 */
	@Override
	public StandardDto updateMerchandise(Merchandise merchandise, MerchandiseRequestDto merchandiseRequest) {

		StandardDto standardDto = null;

		if (!merchandiseRequest.getNameProduct().equals(merchandise.getNameProduct())) {
			Optional<Merchandise> optMerchandise = merchandiseDao
					.findByNameProduct(merchandiseRequest.getNameProduct());

			if (!optMerchandise.isPresent()) {
				merchandise.setNameProduct(merchandiseRequest.getNameProduct());
			} else {
				// Error if exists
				standardDto = new StandardDto("NOT OK", true, "Error, el nombre del producto ya existe.");
			}
		}
		if (standardDto == null) {
			merchandise.setQuantity(merchandiseRequest.getQuantity());
			merchandiseDao.save(merchandise);

			MaintenanceMerchandise maintenanceMerchandise = new MaintenanceMerchandise();
			User user = new User();
			user.setIdUser(merchandiseRequest.getUserId());
			maintenanceMerchandise.setMerchandise(merchandise);
			maintenanceMerchandise.setUser(user);
			maintenanceMerchandise.setCreatedAt(LocalDateTime.now());
			maintenanceMerchandiseDao.save(maintenanceMerchandise);
			standardDto = new StandardDto("OK", false, "El registro se ha actualizado correctamente!");
		}
		return standardDto;
	}

	@Override
	public List<MerchandiseDto> findByNameProduct(String nameProduct) {
		List<MerchandiseDto> listMerchandise = new ArrayList<>();
		if (nameProduct.trim().isBlank() || nameProduct == null) {
			merchandiseDao.findAll().forEach(merchandise -> {
				listMerchandise.add(new MerchandiseDto(merchandise.getIdMerchandise(), merchandise.getNameProduct(),
						merchandise.getQuantity(), merchandise.getUser().getIdUser(), merchandise.getUser().getName(),
						merchandise.getAdmissionDate()));
			});
		} else {
			Optional<Merchandise> optMerchandise = merchandiseDao.findByNameProduct(nameProduct);
			if (optMerchandise.isPresent()) {
				listMerchandise.add(new MerchandiseDto(optMerchandise.get().getIdMerchandise(),
						optMerchandise.get().getNameProduct(), optMerchandise.get().getQuantity(),
						optMerchandise.get().getUser().getIdUser(), optMerchandise.get().getUser().getName(),
						optMerchandise.get().getAdmissionDate()));
			}
		}

		return listMerchandise;
	}

}
