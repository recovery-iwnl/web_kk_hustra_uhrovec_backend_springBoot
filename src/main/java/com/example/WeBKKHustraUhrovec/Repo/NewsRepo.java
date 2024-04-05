package com.example.WeBKKHustraUhrovec.Repo;

import com.example.WeBKKHustraUhrovec.Entity.Image;
import com.example.WeBKKHustraUhrovec.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface NewsRepo extends JpaRepository<News,Integer> {

    List<News> findAllByOrderByDateDesc();

    List<News> findAllByImage(Image image);
}
