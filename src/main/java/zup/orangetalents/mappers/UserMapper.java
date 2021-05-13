package zup.orangetalents.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zup.orangetalents.entity.User;
import zup.orangetalents.model.AddressResponse;
import zup.orangetalents.model.UserRequest;
import zup.orangetalents.model.UserResponse;

@Component
public class UserMapper {

	@Autowired
	AddressMapper addressMapper;
	
	public User modelToEntity(UserRequest model) {
		return new User(model.getName(), model.getEmail(), model.getCpf(), model.getDateBirth());
	}
	
	public UserResponse entityToModel(User entity) {
		
		List<AddressResponse> addresses = entity.getAdresses().stream().map(s -> addressMapper.entityToModel(s)).collect(Collectors.toList());
		
		
		return new UserResponse(entity.getId(), entity.getName(), entity.getEmail(), entity.getCpf(), entity.getDateBirth(), addresses);
	}
}
