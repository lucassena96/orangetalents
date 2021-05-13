package zup.orangetalents.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserResponse {

	private Integer id;
	
	private String name;
	
	private String email;
	
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateBirth;
	
	private List<AddressResponse> addresses;
	
	public UserResponse(Integer id, String name, String email, String cpf, Date dateBirth, List<AddressResponse> addresses) {
		//
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.dateBirth = dateBirth;
		this.addresses = addresses;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getCpf() {
		return this.cpf;
	}

	public Date getDateBirth() {
		return this.dateBirth;
	}
	
	public List<AddressResponse> getAddresses() {
		return this.addresses;
	}
}
