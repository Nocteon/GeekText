package com.example.geektext.Feature2BookDetails.Repo;
import com.example.geektext.Feature2BookDetails.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, String> {
}
