package com.jsp.ecommerce.repository;

import com.jsp.ecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    Address findByUserIdAndIsDefaultTrue(long userId);

    List<Address> findByUser_Id(long userId);

    Long id(long id);
}
