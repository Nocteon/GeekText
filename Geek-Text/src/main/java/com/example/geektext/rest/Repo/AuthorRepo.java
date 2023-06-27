package com.example.geektext.rest.Repo;
import com.example.geektext.rest.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
