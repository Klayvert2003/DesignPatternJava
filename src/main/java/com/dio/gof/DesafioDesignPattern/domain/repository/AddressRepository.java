package com.dio.gof.DesafioDesignPattern.domain.repository;

import com.dio.gof.DesafioDesignPattern.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
