package com.example.WeBKKHustraUhrovec.Repo;

import com.example.WeBKKHustraUhrovec.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface NewsRepo extends JpaRepository<News,Integer> {
}
