package com.example.geektext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("wishlist")
public class WishlistController {

    @Autowired
    private WishlistRepository wishlistRepository;

    @GetMapping("/")
    public Wishlist getWishlist(@RequestParam("title") String title, @RequestParam("user") String user) {
        Wishlist wishlist = wishlistRepository.findByTitleAndUser(title, user);
        if (wishlist == null) {
            return new Wishlist(null, null);
        }
        return wishlist;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createWishlist(@RequestParam("userId") String userId,
                                                 @RequestParam("wishlistName") String wishlistName) {
        Wishlist wishlist = new Wishlist(userId, wishlistName);
        // Save the wishlist to the database using wishlistRepository

        return ResponseEntity.ok().body("Wishlist created.");
    }

        @PostMapping(value = "/addBook")
        public ResponseEntity<String> addBookToWishlist(@RequestParam("bookId") String bookId,
                                                        @RequestParam("wishlistId") Long wishlistId) {
            // Add the book to the specified wishlist using the wishlistId
            return ResponseEntity.ok().body("Book added to wishlist.");
        }


        @DeleteMapping(value = "/removeBook")
        public ResponseEntity<String> removeBookFromWishlist(@RequestParam("bookId") String bookId,
                                                             @RequestParam("wishlistId") Long wishlistId) {
            // Remove the book from the specified wishlist using the wishlistId
            return ResponseEntity.ok().body("Book removed from wishlist and added to shopping cart.");
        }

        @GetMapping(value = "/listBooks")
        public ResponseEntity<List<String>> listBooksInWishlist(@RequestParam("wishlistId") Long wishlistId) {
            Optional<Wishlist> optionalWishlist = wishlistRepository.findById(wishlistId);

            if (optionalWishlist.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Wishlist wishlist = optionalWishlist.get();
            List<String> books = wishlist.getBooks();
            // List all books in a wishlist
            return ResponseEntity.ok().body(books);
        }
    }