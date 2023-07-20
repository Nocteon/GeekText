package com.example.geektext.Feature6Wishlist.Repositories;

import com.example.geektext.Feature6Wishlist.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
