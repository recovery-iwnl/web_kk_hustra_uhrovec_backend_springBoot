package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Dto.CommentDTO;
import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.CommentLiked;
import com.example.WeBKKHustraUhrovec.Service.CommentLikedService;
import com.example.WeBKKHustraUhrovec.Service.CommentService;
import com.example.WeBKKHustraUhrovec.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/commentLiked")
public class CommentLikedControlled {

    @Autowired
    private CommentLikedService commentLikedService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping(path = "/like")
    public ResponseEntity<String> likeComment(@RequestParam String email, @RequestParam String commentID,
                                              @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || jwtTokenUtil.isTokenExpired(token.substring(7))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        String result = commentLikedService.likeComment(email, commentID);
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "/getCommentLikes")
    public Integer getCommentLikes(@RequestParam String commentID) {
        return commentLikedService.getNumberOfLikesByComment(commentID);
    }

    @GetMapping(path = "/isLiked")
    public Boolean getisLiked(@RequestParam String email, @RequestParam String commentID) {
        return commentLikedService.isLiked(email,commentID);
    }
}

