package zup.orangetalents.controller;


import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import zup.orangetalents.entity.Address;
import zup.orangetalents.entity.User;
import zup.orangetalents.exception.AddressException;
import zup.orangetalents.exception.UserException;
import zup.orangetalents.mappers.AddressMapper;
import zup.orangetalents.mappers.UserMapper;
import zup.orangetalents.model.AddressRequest;
import zup.orangetalents.model.AddressResponse;
import zup.orangetalents.model.UserRequest;
import zup.orangetalents.model.UserResponse;


@RestController
public class AddressController {
	
	@Autowired
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	AddressMapper addressMapper;

    @PostMapping("/address")
    @Transactional
    public ResponseEntity<AddressResponse> register(@RequestBody @Valid AddressRequest userRequest) throws AddressException {
		List<?> users = entityManager
				.createQuery("SELECT u FROM User u WHERE u.id = :id")
				.setParameter("id", userRequest.getUserId())
				.getResultList();
		
		if(users.size() == 0) {
			throw new AddressException(HttpStatus.BAD_REQUEST, "Não foi possível salvar o endereço, o id do usuário informado é inválido.");
		}
		
		Address address = addressMapper.modelToEntity(userRequest);
		entityManager.persist(address);
		
		return new ResponseEntity<>(addressMapper.entityToModel(address), HttpStatus.CREATED);
    }
}
