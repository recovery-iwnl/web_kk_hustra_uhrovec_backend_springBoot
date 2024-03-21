package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Repo.CommentRepo;
import com.example.WeBKKHustraUhrovec.Repo.UserRepo;
import com.example.WeBKKHustraUhrovec.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentIMPL implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Comment addComment(String email, Comment comment) {
        User userN = userRepo.findByEmail(email);
        Comment comment1 = new Comment(comment.getText(), comment.getSubject(), userN,0, comment.getDate());
        return commentRepo.save(comment1);
    }

    @Override
    public List<Comment> getComments(Integer number) {
        if (number == 1) {
            return commentRepo.findAllByOrderByDateDesc();
        } else if (number == 2) {
            return commentRepo.findAllByOrderByDateAsc();
        } else {
            return commentRepo.findAllByOrderByLikesDesc();
        }
    }

    @Override
    public String likeComment(Long id) {
        Comment commentN = commentRepo.findById(id).orElse(null);
        if (commentN != null) {
            commentN.setLikes(commentN.getLikes()+1);
            commentRepo.save(commentN);
            return "Comment liked:";
        } else {
            return "Comment doesnt exist!";
        }

    }

    @Override
    public String deleteComment(Long id) {
        Comment comment = commentRepo.findById(id).orElse(null);
        if (comment!=null) {
            commentRepo.deleteById(id);
            return "Comment deleted successfully";
        } else {
            return "Comment not found";
        }
    }
}
