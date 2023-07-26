package com.geektext.app.rest.Controllers;

import com.geektext.app.rest.Models.Comment;
import com.geektext.app.rest.Repo.CommentRepo;
import com.geektext.app.rest.Requests.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepo commentRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createComment(@RequestBody CommentRequest commentRequest) {
        // Get the user id and book id from the request
        Long userId = commentRequest.getUserId();
        Long bookId = commentRequest.getBookId();
        String comment = commentRequest.getComment();


        // Create a new Comment object
        Comment content = new Comment(comment, new Date());

        // Save the comment to the database
        commentRepo.save(content);

        return "Comment saved";
    }


    @GetMapping("/{bookId}")
    public List<Comment> getCommentsForBook(@RequestParam Long bookId) {

        List<Comment> comments = commentRepo.findByBookId(bookId);

        return comments;
    }
}
