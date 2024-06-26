package com.example.WeBKKHustraUhrovec.Repo;


import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

    List<Comment> findAllByOrderByDateDesc();
    List<Comment> findAllByOrderByDateAsc();

    void deleteAllByUser(User user);
}
