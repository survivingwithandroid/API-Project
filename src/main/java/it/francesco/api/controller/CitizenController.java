package it.francesco.api.controller;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.francesco.api.dto.CitizensDTO;
import it.francesco.api.exception.ResourceNotFoundException;
import it.francesco.api.model.Citizen;
import it.francesco.api.repository.CitizenRepository;


@RestController
@RequestMapping("/api/v1")
@Validated
public class CitizenController {
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	@GetMapping("/dati")
	public ResponseEntity<CitizensDTO> getCitizens(
			@RequestParam(name="codice-fiscale") @NotBlank @Size(max=16) String fiscalCode,
			@RequestParam(name="offset") @Min(0) @NotNull Integer offset,
			@RequestParam(name="limit")  @Min(0) @NotNull Integer limit) throws ResourceNotFoundException {
		
		OffsetBasedPageRequest request = new OffsetBasedPageRequest(limit, offset);
		List<Citizen> result = citizenRepository.findCitizensByFiscalCode(fiscalCode, request);
		
		// Get count
		int count = citizenRepository.getCount(fiscalCode);
		
		// Check if the result is null or empty. In this case it throws a ResourceNotFoundException
		if (result == null || result.size() == 0) 
			throw new ResourceNotFoundException("No citizen found with fiscal code: " + fiscalCode);
		
		CitizensDTO citizens = new CitizensDTO(result, offset, count);
		
		
		return new ResponseEntity<CitizensDTO>(citizens, HttpStatus.OK);
	}

}
