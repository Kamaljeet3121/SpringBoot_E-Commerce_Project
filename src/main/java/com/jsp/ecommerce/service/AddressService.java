package com.jsp.ecommerce.service;


import com.jsp.ecommerce.dto.AddressCreationReq;
import com.jsp.ecommerce.dto.AddressResponse;
import com.jsp.ecommerce.dto.AddressUpdateReq;

import java.util.List;

public interface AddressService {
    AddressResponse createAddress(AddressCreationReq addressCreationReq);
    List<AddressResponse> getAddresses(long id);
    AddressResponse updateAddress(AddressUpdateReq addressUpdateReq);
    AddressResponse deleteAddress(long id);
}
