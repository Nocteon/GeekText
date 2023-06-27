package com.example.geektext.rest.Repo;
import com.example.geektext.rest.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
