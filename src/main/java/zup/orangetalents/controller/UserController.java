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

import zup.orangetalents.entity.User;
import zup.orangetalents.exception.UserException;
import zup.orangetalents.mappers.UserMapper;
import zup.orangetalents.model.UserRequest;
import zup.orangetalents.model.UserResponse;


@RestController
public class UserController {
	
	@Autowired
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserMapper userMapper;

    @PostMapping("/user")
    @Transactional
    public ResponseEntity<UserResponse> register(@RequestBody @Valid UserRequest userRequest) throws UserException {

    	List<?> result = entityManager
			    		.createQuery("SELECT u FROM User u WHERE u.email like :email or u.cpf like :cpf")
			    		.setParameter("email", userRequest.getEmail())
			    		.setParameter("cpf", userRequest.getCpf())
			    		.getResultList();
    	
    	//
    	if(result.size() >= 1) 
    		throw new UserException(HttpStatus.BAD_REQUEST, "Não foi possível registrar o usuário. Existe um mesmo usuário com o mesmo cpf ou email");
    	
    	
    	//
    	User user = userMapper.modelToEntity(userRequest);
    	entityManager.persist(user);
    	
    	//
    	return new ResponseEntity<>(userMapper.entityToModel(user), HttpStatus.CREATED);
    }
    
    
    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable("id") Integer userId) throws UserException {

    	List<?> result = entityManager
			    		.createQuery("SELECT u FROM User u WHERE u.id = :id")
			    		.setParameter("id", userId)
			    		.getResultList();
    	
    	//
    	if(result.size() == 0) 
    		throw new UserException(HttpStatus.BAD_REQUEST, "Não foi possível encontrar o usuário com este id.");
    	
    
    	//
    	return new ResponseEntity<>(userMapper.entityToModel((User)result.get(0)), HttpStatus.OK);
    }
}
