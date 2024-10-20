package com.auctionDemo.Auction.Controller;

import Service.UserService;
import com.auctionDemo.Auction.Entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Users")
public class UserControler {
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
       return userService.getUsers();
    }
}
