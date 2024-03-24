package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Dto.CommentDTO;
import com.example.WeBKKHustraUhrovec.Entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    CommentDTO addComment(String email, Comment comment);

    List<CommentDTO> getComments(Integer number);

    String likeComment(Long id);

    String deleteComment(Long id);
}
