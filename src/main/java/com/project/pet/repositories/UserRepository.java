package com.project.pet.repositories;

import java.util.Optional;

import com.project.pet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);
}
