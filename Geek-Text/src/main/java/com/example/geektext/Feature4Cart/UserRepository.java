package com.GeekText.groupProject.repository;


import com.GeekText.groupProject.model.cartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<cartItems, String> {
}
