package zup.orangetalents.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.NotNull;

public class AddressResponse {

	private Integer id;
	
	private String street;
	
	private String number;
	
	private String complement;
	
	private String district;

	private String city;
	
	private String state;

	private String zipCode;
	
	private Integer userId;
	
	public AddressResponse(Integer id, String street, String number, String complement,
			String district, String city, String state, String zipCode, 
			Integer userId) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.userId = userId;
	}
	
	public AddressResponse() {
	}

	public Integer getId() {
		return this.id;
	}

	public String getStreet() {
		return this.street;
	}

	public String getNumber() {
		return this.number;
	}

	public String getComplement() {
		return this.complement;
	}

	public String getDistrict() {
		return this.district;
	}

	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public Integer getUserId() {
		return this.userId;
	}
}
