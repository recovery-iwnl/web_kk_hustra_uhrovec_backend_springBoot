package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.CommentLiked;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Repo.CommentLikedRepo;
import com.example.WeBKKHustraUhrovec.Repo.CommentRepo;
import com.example.WeBKKHustraUhrovec.Repo.UserRepo;
import com.example.WeBKKHustraUhrovec.Service.CommentLikedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentLikedIMPL implements CommentLikedService {

    @Autowired
    private CommentLikedRepo commentLikedRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public String likeComment(String email, String commentID) {
        User user = userRepo.findByEmail(email);
        Comment comment = getCommentById(commentID);

        CommentLiked existingLike = commentLikedRepo.findByUserAndComment(user, comment);

        if (existingLike != null) {
            commentLikedRepo.delete(existingLike);
            return "Comment unliked successfully.";
        } else {
            CommentLiked newLike = new CommentLiked(user, comment);
            commentLikedRepo.save(newLike);
            return "Comment liked successfully.";
        }
    }

    @Override
    public Integer getNumberOfLikesByComment(String commentID) {
        Comment comment = getCommentById(commentID);
        return commentLikedRepo.countByComment(comment);
    }

    @Override
    public Boolean isLiked(String email, String commentID) {
        User user = userRepo.findByEmail(email);
        Comment comment = getCommentById(commentID);
        CommentLiked existingLike = commentLikedRepo.findByUserAndComment(user, comment);
        return existingLike != null;
    }

    private Comment getCommentById(String commentID) {
        return commentRepo.findById(Long.valueOf(commentID))
                .orElseThrow(() -> new RuntimeException("Comment not found with ID: " + commentID));
    }
}