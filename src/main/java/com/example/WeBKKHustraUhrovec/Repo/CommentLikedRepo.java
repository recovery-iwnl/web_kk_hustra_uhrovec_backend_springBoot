package com.example.WeBKKHustraUhrovec.Repo;

import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.CommentLiked;
import com.example.WeBKKHustraUhrovec.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CommentLikedRepo extends JpaRepository<CommentLiked, Long> {

    CommentLiked findByUserAndComment(User user, Comment comment);

    Integer countByComment(Comment comment);

    void deleteAllByComment(Comment comment);
}
