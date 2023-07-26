package com.geektext.app.rest.Repo;

import com.geektext.app.rest.Models.Rating;
import com.geektext.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
