package com.GeekText.groupProject.service.service;

import com.GeekText.groupProject.model.cartItems;
import com.GeekText.groupProject.repository.BookRepository;
import com.GeekText.groupProject.repository.shoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class shoppingCartService {
    @Autowired
    private shoppingCartRepository shoppingcartrepository;
    @Autowired
    private BookRepository bookRepository;

    public void addItems(cartItems item) {
        shoppingcartrepository.insertItem(item.getUserId(), item.getBookId(), item.getPrice(), item.getQuantity(), item.getSubtotal());
    }

    public void removeItems(cartItems item) {
       shoppingcartrepository.delete(item);
    }

    public List<cartItems> getBooksByUserId(String userId){
        return shoppingcartrepository.findByUserIdIs(userId);
    }

    public Double getTotalPriceByUserId(String userId){
        return shoppingcartrepository.getSubtotalPriceByUserId(userId);
    }
}
