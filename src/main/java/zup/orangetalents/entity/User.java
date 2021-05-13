package zup.orangetalents.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	@NotNull
	private String name;
	
	@Email
	@Column(unique = true)
	private String email;
	
	@CPF
	@Column(unique = true)
	private String cpf;
	
	@NotNull
	@Past
	private Date dateBirth;
	
	@OneToMany(mappedBy = "user")
	List<Address> addresses = new ArrayList<>();
	
	public User(@NotBlank String name, @Email String email, @CPF String cpf, @Past Date dateBirth) {
		//
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.dateBirth = dateBirth;
	}
	
	public User() {}

	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}
	
	public Date getDateBirth() {
		return dateBirth;
	}
	
	public List<Address> getAdresses() {
		return addresses;
	}
}
