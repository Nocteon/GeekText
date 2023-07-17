package com.example.geektext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    // Create a new wishlist for a user
    @PostMapping("/create")
    public Wishlist createWishlist(@RequestParam Long userId, @RequestParam String wishlistId) {
        return wishlistService.createWishlist(userId, wishlistId);
    }

    // Add a book to a wishlist
    @PostMapping("/{wishlistId}/addBook")
    public Wishlist addBookToWishlist(@PathVariable String wishlistId, @RequestParam String bookId) {
        return wishlistService.addBookToWishlist(wishlistId, bookId);
    }

    // Remove a book from a wishlist
    @DeleteMapping("/{wishlistId}/removeBook")
    public void removeBookFromWishlist(@PathVariable String wishlistId, @RequestParam String bookId) {
        wishlistService.removeBookFromWishlist(wishlistId, bookId);
    }

    // Get the books in a wishlist
    @GetMapping("/{wishlistId}/books")
    public List<Book> getBooksInWishlist(@PathVariable String wishlistId) {
        return wishlistService.getBooksInWishlist(wishlistId);
    }
}
