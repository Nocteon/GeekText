package com.example.geektext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, String> {
    Wishlist findByTitleAndUser(String title, String user);

    Optional<Wishlist> findById(Long wishlistId);
}
