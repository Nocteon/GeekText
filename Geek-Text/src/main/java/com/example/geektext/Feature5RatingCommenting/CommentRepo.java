package com.geektext.app.rest.Repo;

import com.geektext.app.rest.Models.Comment;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {

    List<Comment> findByBookId(Long bookId);
}
