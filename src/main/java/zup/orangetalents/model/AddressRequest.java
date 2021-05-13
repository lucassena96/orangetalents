package zup.orangetalents.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressRequest {

	@NotBlank
	private String street;
	
	@NotNull
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
	
	@NotNull
	private Integer userId;

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
