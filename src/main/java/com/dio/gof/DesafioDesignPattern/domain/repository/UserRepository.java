package com.dio.gof.DesafioDesignPattern.domain.repository;

import com.dio.gof.DesafioDesignPattern.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
