package com.GeekText.groupProject.controller;

import com.GeekText.groupProject.model.cartItems;
import com.GeekText.groupProject.repository.BookRepository;
import com.GeekText.groupProject.repository.UserRepository;
import com.GeekText.groupProject.service.service.shoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cartItems")
public class ShoppingCartController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private shoppingCartService shoppingcartservice;

    @PostMapping(value = "/addUser_addBook")
    public String addToCart(@RequestParam(name = "userId") String userId, @RequestParam(name = "bookId") Long bookId) {
        cartItems items = new cartItems();
        items.setUserId(userId);
        items.setBookId(bookId);
        items.setPrice(7.99);
        items.setQuantity(1);
        double subtotal = 7.99 * items.getQuantity();
        items.setSubtotal(subtotal);
        shoppingcartservice.addItems(items);
        return "";
    }
    @DeleteMapping(value = "/removeitem")
    public String removeItem(@RequestParam(name = "userId") String userId, @RequestParam(name = "bookId") Long bookId){
        cartItems items = new cartItems();
        items.setUserId(userId);
        items.setBookId(bookId);
        shoppingcartservice.removeItems(items);
        return "";
    }

    @GetMapping(value = "/getcart")
    public List<Long> getCart(@RequestParam(name = "userId") String userId){
        List<cartItems> cartItemsList = shoppingcartservice.getBooksByUserId(userId);
        List<Long> bookIdsList = new ArrayList<>();
        for (cartItems item : cartItemsList){
            bookIdsList.add(item.getBookId());
        }
        return bookIdsList;
    }

    @GetMapping(value = "/getsubtotal")
    public double getSubtotalPrice(@RequestParam(name = "userId")String userId){
        return shoppingcartservice.getTotalPriceByUserId(userId);
    }



}

