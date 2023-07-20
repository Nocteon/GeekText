package com.example.geektext.Feature6Wishlist.Repositories;

import com.example.geektext.Feature6Wishlist.Models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, String> {
}
