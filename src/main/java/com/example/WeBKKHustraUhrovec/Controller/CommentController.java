package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Entity.Comment;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @PostMapping(path = "/save")
    public Comment saveComment(@RequestParam String email,@RequestBody Comment comment) {
        return commentService.addComment(email, comment);
    }
}
