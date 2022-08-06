package com.hp.gekko.ordermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hp.gekko.ordermanagement.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	Optional<Address> findByAddressId(Long addressId);

	Optional<Address> deleteByAddressId(Long addressId);

}
