package com.treino.crud.repository;

import com.treino.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // O Spring Data JPA já implementa .save(), .findAll(), .findById(), .deleteById() automaticamente!
}