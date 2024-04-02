package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Dto.CommentDTO;
import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.CommentLiked;
import com.example.WeBKKHustraUhrovec.Service.CommentLikedService;
import com.example.WeBKKHustraUhrovec.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/commentLiked")
public class CommentLikedControlled {

    @Autowired
    private CommentLikedService commentLikedService;

    @PostMapping(path = "/like")
    public String likeComment(@RequestParam String email, @RequestParam String commentID) {
        return commentLikedService.likeComment(email, commentID);
    }

    @GetMapping(path = "/getCommentLikes")
    public Integer getCommentLikes(@RequestParam String commentID) {
        return commentLikedService.getNumberOfLikesByComment(commentID);
    }

    @GetMapping(path = "/isLiked")
    public Boolean getCommentLikes(@RequestParam String email, @RequestParam String commentID) {
        return commentLikedService.isLiked(email,commentID);
    }
}

