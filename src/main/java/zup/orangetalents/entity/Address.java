package zup.orangetalents.entity;

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

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	private String street;
	
	@NotBlank
	private String number;
	
	@NotBlank
	private String complement;
	
	@NotBlank
	private String district;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	@NotBlank
	private String zipCode;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, nullable = false, updatable = false)
	private User user;
	
	public Address(@NotBlank String street, @NotBlank String number, @NotBlank String complement,
			@NotBlank String district, @NotBlank String city, @NotBlank String state, @NotBlank String zipCode, 
			@NotNull Integer userId) {
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.userId = userId;
	}
	
	public Address() {
	}

	public Integer getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getNumber() {
		return number;
	}

	public String getComplement() {
		return complement;
	}

	public String getDistrict() {
		return district;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public User getUser() {
		return user;
	}
}
