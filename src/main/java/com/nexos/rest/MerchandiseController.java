/**
 * 
 */
package com.nexos.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.exception.ResourceNotFoundException;
import com.nexos.model.dto.StandardDto;
import com.nexos.model.entities.Merchandise;
import com.nexos.model.services.IMerchandiseService;

/**
 * @author Soluciones
 *
 */
@RestController
@RequestMapping(value = "api/v1/merchandise")
public class MerchandiseController {

	@Autowired
	private IMerchandiseService merchandiseService;

	@GetMapping(value = "/")
	public List<Merchandise> getAllMerchandise() {
		return merchandiseService.getAllMerchandise();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Merchandise> getEmployeeById(@PathVariable(value = "id") int merchandiseId)
			throws ResourceNotFoundException {
		Merchandise merchandise = merchandiseService.findById(merchandiseId).orElseThrow(
				() -> new ResourceNotFoundException("Merchandise not found for this id :: " + merchandiseId));
		return ResponseEntity.ok().body(merchandise);
	}

	@PostMapping(value = "/")
	public Merchandise createMerchandise(@Validated @RequestBody Merchandise merchandise) {
		return merchandiseService.saveMerchandise(merchandise);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<StandardDto> updateMerchandise(@PathVariable(value = "id") int merchandiseId,
         @Validated @RequestBody Merchandise merchandiseRequest) throws ResourceNotFoundException {
		Merchandise merchandise = merchandiseService.findById(merchandiseId).orElseThrow(
				() -> new ResourceNotFoundException("Merchandise not found for this id :: " + merchandiseId)
			);

        final StandardDto updatedStandard = merchandiseService.updateMerchandise(merchandise, merchandiseRequest);
        return ResponseEntity.ok(updatedStandard);
    }

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int merchandiseId)
			throws ResourceNotFoundException {

		Merchandise merchandise = merchandiseService.findById(merchandiseId).orElseThrow(
				() -> new ResourceNotFoundException("Merchandise not found for this id :: " + merchandiseId));

		merchandiseService.deleteMerchandise(merchandise);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
