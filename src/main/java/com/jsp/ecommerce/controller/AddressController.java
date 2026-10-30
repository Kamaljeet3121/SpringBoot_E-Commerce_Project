package com.jsp.ecommerce.controller;

import com.jsp.ecommerce.dto.AddressCreationReq;
import com.jsp.ecommerce.dto.AddressResponse;
import com.jsp.ecommerce.dto.AddressUpdateReq;
import com.jsp.ecommerce.service.imp.AddressServiceImp1;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressServiceImp1 addService;

    @PostMapping
    public ResponseEntity<AddressResponse> CreateAddress(@RequestBody @Valid AddressCreationReq addressCreationReq){

        return ResponseEntity.status(HttpStatus.CREATED).body(addService.createAddress(addressCreationReq));
    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> GetAddresses(@RequestParam long id){

        return ResponseEntity.status(HttpStatus.FOUND).body(addService.getAddresses(id));
    }

    @PutMapping
    public ResponseEntity<AddressResponse> updateAddress(@RequestBody @Valid AddressUpdateReq addressUpdateReq) {

        return ResponseEntity.status(HttpStatus.OK).body(addService.updateAddress(addressUpdateReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressResponse> deleteAddress(@PathVariable long id){

        return ResponseEntity.status(HttpStatus.OK).body(addService.deleteAddress(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AddressResponse> markDefaultAddress(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(addService.markAddressDefault(id));

    }
}
