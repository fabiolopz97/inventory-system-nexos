/**
 * 
 */
package com.nexos.model.services;

import java.util.List;
import java.util.Optional;

import com.nexos.model.dto.MerchandiseDto;
import com.nexos.model.dto.MerchandiseRequestDto;
import com.nexos.model.dto.StandardDto;
import com.nexos.model.entities.Merchandise;

/**
 * @author Soluciones
 *
 */
public interface IMerchandiseService {

	public List<MerchandiseDto> getAllMerchandise();

	public MerchandiseDto saveMerchandise(MerchandiseRequestDto merchandise);

	public StandardDto updateMerchandise(Merchandise merchandise, MerchandiseRequestDto merchandiseRequest);

	public void deleteMerchandise(Merchandise merchandise);

	public Optional<Merchandise> findById(int merchandiseId);

	public List<MerchandiseDto> findByNameProduct(String nameProduct);
}
