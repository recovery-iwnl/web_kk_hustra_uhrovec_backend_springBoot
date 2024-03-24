package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Dto.CommentDTO;
import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @PostMapping(path = "/save")
    public CommentDTO saveComment(@RequestParam String email,@RequestBody Comment comment) {
        return commentService.addComment(email, comment);
    }

    @GetMapping(path = "/getCommentsList")
    public List<CommentDTO> getComments(@RequestParam Integer number) {
        return commentService.getComments(number);
    }

    @PutMapping(path = "/likeComment")
    public String likeComment(@RequestParam Long id) {
        return commentService.likeComment(id);
    }

    @DeleteMapping(path = "/deleteComment")
    public String deleteComment(@RequestParam Long id) {
        return commentService.deleteComment(id);
    }
}
