package com.example.WeBKKHustraUhrovec.Repo;


import com.example.WeBKKHustraUhrovec.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
}
