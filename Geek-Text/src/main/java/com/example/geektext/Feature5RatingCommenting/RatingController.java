package com.geektext.app.rest.Controllers;
import com.geektext.app.rest.Models.Rating;
import com.geektext.app.rest.Repo.RatingRepo;
import com.geektext.app.rest.Requests.RatingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingRepo ratingRepo;

    @PostMapping
    public String createRating(@RequestBody RatingRequest ratingRequest) {
        // Get the user id and book id from the request
        Long userId = ratingRequest.getUserId();
        Long bookId = ratingRequest.getBookId();
        int stars = ratingRequest.getStars();



        // Create a new Rating object
        Rating rating = new Rating(stars, new Date());

        // Save the rating to the database
        ratingRepo.save(rating);

        return "Rating saved";
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Double> getAverageRatingForBook(@PathVariable Long bookId) {

        // Calculate the average rating for the book using the repository method
        Double averageRating = ratingRepo.calculateAverageRatingForBook(bookId);

        return ResponseEntity.ok(averageRating);
    }
}
