package com.auctionDemo.Auction.Repository;

import com.auctionDemo.Auction.Entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokkenRepo extends JpaRepository<VerificationToken,Long> {
}
