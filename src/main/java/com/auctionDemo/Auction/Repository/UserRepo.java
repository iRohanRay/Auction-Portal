package com.auctionDemo.Auction.Repository;

import com.auctionDemo.Auction.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
