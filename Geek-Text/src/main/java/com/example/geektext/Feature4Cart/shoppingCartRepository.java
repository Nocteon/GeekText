package com.GeekText.groupProject.repository;

import com.GeekText.groupProject.model.cartItems;
import com.GeekText.groupProject.model.cartItemsId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface shoppingCartRepository extends JpaRepository<cartItems, cartItemsId> {
@Transactional
    @Query(value = "insert into cart_items (user_id, book_id, price, quantity, subtotal) values (:userId, :bookId, :price, :quantity, :subtotal)", nativeQuery = true)
    @Modifying void insertItem(@Param("userId") String userId, @Param("bookId") Long bookId, double price, int quantity, double subtotal);

@Transactional
    @Query(value = "delete from cart_item where (user_id, book_id)", nativeQuery = true)
    @Modifying void removeItem(@Param("userId") String userId, @Param("bookId") Long bookId);

List<cartItems> findByUserIdIs(String userId);

@Query(value = "SELECT SUM (c.price * c.quantity) FROM cartItems c WHERE c.userId = :userId")
    Double getSubtotalPriceByUserId(@Param("userId") String userId);

}
