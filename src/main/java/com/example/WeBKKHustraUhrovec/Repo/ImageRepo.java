package com.example.WeBKKHustraUhrovec.Repo;
import com.example.WeBKKHustraUhrovec.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
}
