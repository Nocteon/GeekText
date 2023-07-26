package com.geektext.app.rest.Repo;
import com.geektext.app.rest.Models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepo extends JpaRepository<Rating, Long> {

    @Query("SELECT AVG(r.ratingScale) FROM Rating r WHERE r.bookId = :bookId")
    Double calculateAverageRatingForBook(@Param("bookId") Long bookId);
}
