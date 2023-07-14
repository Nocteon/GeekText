package com.example.geektext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final BookRepository bookRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, BookRepository bookRepository) {
        this.wishlistRepository = wishlistRepository;
        this.bookRepository = bookRepository;
    }

    public Wishlist createWishlist(String userId, String wishlistId) {
        Wishlist wishlist = new Wishlist();
        wishlist.setUserId(userId);
        wishlist.setWishlistId(wishlistId);
        return wishlistRepository.save(wishlist);
    }

    public Wishlist addBookToWishlist(String wishlistId, String bookId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElse(null);
        if (wishlist != null) {
            Book book = bookRepository.findById(bookId).orElse(null);
            if (book != null) {
                wishlist.getBooks().add(book);
                return wishlistRepository.save(wishlist);
            }
        }
        return null;
    }

    public void removeBookFromWishlist(String wishlistId, String bookId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElse(null);
        if (wishlist != null) {
            Book book = wishlist.getBooks().stream()
                    .filter(b -> b.getBookId().equals(bookId))
                    .findFirst()
                    .orElse(null);
            if (book != null) {
                wishlist.getBooks().remove(book);
                wishlistRepository.save(wishlist);
                // Add code to move the book to the shopping cart
            }
        }
    }

    public List<Book> getBooksInWishlist(String wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElse(null);
        if (wishlist != null) {
            return wishlist.getBooks();
        }
        return null;
    }
}

