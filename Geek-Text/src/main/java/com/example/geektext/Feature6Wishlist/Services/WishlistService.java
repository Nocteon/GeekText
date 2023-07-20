package com.example.geektext.Feature6Wishlist.Services;

import com.example.geektext.Feature6Wishlist.Repositories.BookRepository;
import com.example.geektext.Feature6Wishlist.Models.Book;
import com.example.geektext.Feature6Wishlist.Models.Wishlist;
import com.example.geektext.Feature6Wishlist.Repositories.WishlistRepository;
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

    // Create a new wishlist for a user
    public Wishlist createWishlist(Long userId, String wishlistId) {
        Wishlist wishlist = new Wishlist();
        wishlist.setUserId(userId);
        wishlist.setWishlistId(wishlistId);
        return wishlistRepository.save(wishlist);
    }

    // Add a book to a wishlist
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

    // Remove a book from a wishlist
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

    // Get the books in a wishlist
    public List<Book> getBooksInWishlist(String wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElse(null);
        if (wishlist != null) {
            return wishlist.getBooks();
        }
        return null;
    }
}

