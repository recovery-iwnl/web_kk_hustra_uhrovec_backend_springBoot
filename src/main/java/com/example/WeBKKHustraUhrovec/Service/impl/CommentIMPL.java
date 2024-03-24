package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Dto.CommentDTO;
import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Repo.CommentRepo;
import com.example.WeBKKHustraUhrovec.Repo.UserRepo;
import com.example.WeBKKHustraUhrovec.Service.CommentService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentIMPL implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public CommentDTO addComment(String email, Comment comment) {
        User userN = userRepo.findByEmail(email);
        Comment comment1 = new Comment(comment.getText(), comment.getSubject(), userN,0, comment.getDate());
        commentRepo.save(comment1);
        return getCommentDTO(comment1);
    }

    @NotNull
    private CommentDTO getCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setText(comment.getText());
        commentDTO.setSubject(comment.getSubject());
        commentDTO.setUsername(comment.getUser().getUserName());
        commentDTO.setRole(comment.getUser().getRole());
        commentDTO.setLikes(comment.getLikes());
        commentDTO.setDate(comment.getDate());
        return commentDTO;
    }

    @Override
    public List<CommentDTO> getComments(Integer number) {
        List<Comment> comments;
        if (number == 1) {
            comments = commentRepo.findAllByOrderByDateDesc();
        } else if (number == 2) {
            comments = commentRepo.findAllByOrderByDateAsc();
        } else {
            comments = commentRepo.findAllByOrderByLikesDesc();
        }

        return comments.stream()
                .map(this::getCommentDTO)
                .collect(Collectors.toList());
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
