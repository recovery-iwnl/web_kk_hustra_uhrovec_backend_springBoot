package com.example.WeBKKHustraUhrovec.Repo;

import com.example.WeBKKHustraUhrovec.Entity.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);
}
