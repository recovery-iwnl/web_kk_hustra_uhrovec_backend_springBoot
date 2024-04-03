package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Dto.CommentDTO;
import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Service.CommentService;
import com.example.WeBKKHustraUhrovec.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping(path = "/save")
    public ResponseEntity<CommentDTO> saveComment(@RequestParam String email, @RequestBody Comment comment,
                                                  @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || jwtTokenUtil.isTokenExpired(token.substring(7))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        CommentDTO savedComment = commentService.addComment(email, comment);
        return ResponseEntity.ok(savedComment);
    }
    @GetMapping(path = "/getCommentsList")
    public List<CommentDTO> getComments(@RequestParam Integer number) {
        return commentService.getComments(number);
    }

    @DeleteMapping(path = "/deleteComment")
    public ResponseEntity<String> deleteComment(@RequestParam Long id,
                                                @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || jwtTokenUtil.isTokenExpired(token.substring(7))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        String result = commentService.deleteComment(id);
        return ResponseEntity.ok(result);
    }
}
