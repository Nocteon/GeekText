package com.example.geektext.Feature5RatingCommenting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {
    Scanner scanner = new Scanner(System.in);

    @PostMapping
    public ResponseEntity<?> createComment() {
        System.out.print("Enter your User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter the Book ID: ");
        String bookId = scanner.nextLine();

        System.out.print("Enter your comment: ");
        String comment = scanner.nextLine();

        String message = "Comment created successfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

}
