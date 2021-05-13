package zup.orangetalents.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserRequest {

	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@CPF
	private String cpf;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Past
	private Date dateBirth;

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
}
