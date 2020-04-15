package it.francesco.api.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




// Model class for Citizen
@Entity
@Table(name="citizen")
public class Citizen {
	
	// Citizen ID
	private long id;
	
	// Citizen name
	private String name;
	
	// Citizen surname
	private String surname;
	
	// Citizen birth date
	private Date birthDate;
	
	// Citizen fiscal code
	private String fiscalCode;

	
	// Public constructor
	public Citizen() {		
	}

	public Citizen(String name, String surname, Date birthDate, String fiscalCode) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.fiscalCode = fiscalCode;
	}

	// Getter and setter methods
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "first_name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname", nullable = false)
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "fiscal_code", nullable = false)
	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	
	

}
