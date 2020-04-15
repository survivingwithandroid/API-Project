package it.francesco.api.dto;

import java.util.List;

import it.francesco.api.model.Citizen;

// Data transfer object to wrap the inner Entity class

public class CitizensDTO {
	
	// Citizens list 
	private List<Citizen> citizens;
	private int offset;
	private int total;

	// Public constructor
	public CitizensDTO(List<Citizen> citizens, int offset, int total) {
		super();
		this.citizens = citizens;
		this.offset = offset;
		this.total = total;
	}

	
	// Public getter and setter method
	public List<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}


	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
