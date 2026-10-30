package com.jsp.ecommerce.service.imp;

import com.jsp.ecommerce.dto.AddressCreationReq;
import com.jsp.ecommerce.dto.AddressResponse;
import com.jsp.ecommerce.dto.AddressUpdateReq;
import com.jsp.ecommerce.entity.Address;
import com.jsp.ecommerce.entity.User;
import com.jsp.ecommerce.exception.AddressNotFound;
import com.jsp.ecommerce.repository.AddressRepository;
import com.jsp.ecommerce.repository.UserRepository;
import com.jsp.ecommerce.service.AddressService;
import com.jsp.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImp1 implements AddressService {
    private final UserRepository userRepo;
    private final UserService userService;
    private final AddressRepository addRepo;
    private final ObjectMapper objectMapper;


    public AddressResponse createAddress(AddressCreationReq addressCreationReq) {

        User user = userService.findById(addressCreationReq.getUserId());

        Address address = objectMapper.convertValue(addressCreationReq, Address.class);
        address.setUser(user);

        return objectMapper.convertValue(addRepo.save(address), AddressResponse.class);

    }

    public List<AddressResponse> getAddresses(long id) {
        User user = userService.findById(id);

        List<AddressResponse> addresses = new ArrayList<>();

        user.getAddresses().stream()
                            .forEach(address->addresses
                            .add(objectMapper.convertValue(address, AddressResponse.class)));

        return addresses;
    }

    public AddressResponse updateAddress(AddressUpdateReq addressUpdateReq) {
        Address oldAddress = addRepo.findById(addressUpdateReq.getId())
                .orElseThrow(()->new AddressNotFound("Address with id "+addressUpdateReq.getId()+" not found"));

        Address address = objectMapper.convertValue(addressUpdateReq, Address.class);
        address.setUser(oldAddress.getUser());

        return objectMapper.convertValue(addRepo.save(address), AddressResponse.class);

    }

    public AddressResponse deleteAddress(long id) {
        Address address = addRepo.findById(id)
                .orElseThrow(() -> new AddressNotFound("Address with id "+id+" not found"));

//        User user =address.getUser();
//        user.getAddresses().remove(address);
//        userRepo.save(user);

        addRepo.delete(address);
        return objectMapper.convertValue(address, AddressResponse.class);

    }
}
