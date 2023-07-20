package com.example.geektext.Feature2BookDetails.Repo;
import com.example.geektext.Feature2BookDetails.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
