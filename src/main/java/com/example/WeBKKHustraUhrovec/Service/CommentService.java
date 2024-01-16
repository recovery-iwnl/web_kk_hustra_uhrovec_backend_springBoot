package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    Comment addComment(String email, Comment comment);

    List<Comment> getComments(Integer number);

    String likeComment(Long id);

    String deleteComment(Long id);
}
