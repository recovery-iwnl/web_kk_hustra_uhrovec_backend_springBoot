package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Repo.CommentRepo;
import com.example.WeBKKHustraUhrovec.Repo.UserRepo;
import com.example.WeBKKHustraUhrovec.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentIMPL implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Comment addComment(String email, Comment comment) {
        User userN = userRepo.findByEmail(email);
        Comment comment1 = new Comment(comment.getText(), userN,0, comment.getDate());
        return commentRepo.save(comment1);
    }
}
