package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Dto.CommentDTO;
import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.CommentLiked;
import org.springframework.stereotype.Service;

@Service
public interface CommentLikedService {

    String likeComment(String email, String commentID);

    Integer getNumberOfLikesByComment(String commentID);

    Boolean isLiked(String email, String commentID);
}
