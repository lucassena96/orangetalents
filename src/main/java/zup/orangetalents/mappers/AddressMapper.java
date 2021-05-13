package zup.orangetalents.mappers;

import org.springframework.stereotype.Component;

import zup.orangetalents.entity.Address;
import zup.orangetalents.entity.User;
import zup.orangetalents.model.AddressRequest;
import zup.orangetalents.model.AddressResponse;
import zup.orangetalents.model.UserRequest;

@Component
public class AddressMapper {
	
	public Address modelToEntity(AddressRequest model) {
		return new Address(model.getStreet(), model.getNumber(), model.getComplement(),
				model.getDistrict(), model.getCity(), model.getState(), model.getZipCode(), 
				model.getUserId());
	}
	
	public AddressResponse entityToModel(Address entity) {
		
		return new AddressResponse(entity.getId(), entity.getStreet(), entity.getNumber(), entity.getComplement(),
				entity.getDistrict(), entity.getCity(), entity.getState(), entity.getZipCode(), 
				entity.getUserId());
	}
}
