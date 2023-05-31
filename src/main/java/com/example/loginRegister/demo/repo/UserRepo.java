package com.example.loginRegister.demo.repo;

import com.example.loginRegister.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);

    Optional<UserEntity> findOneByEmailAndPassword(String email, String encoded_pass);
}
