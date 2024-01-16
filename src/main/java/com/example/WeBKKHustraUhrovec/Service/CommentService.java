package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Entity.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    Comment addComment(String email, Comment comment);
}
