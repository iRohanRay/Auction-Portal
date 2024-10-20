package com.auctionDemo.Auction.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.nio.file.LinkOption;
import java.util.Calendar;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tokken;
    private Date expirationTime;
    private static final int EXPIRATION_TIME=10;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    public VerificationToken(String tokken,User user){
        this.tokken=tokken;
        this.user=user;
        this.expirationTime=this.getTokkenExpirationTime();
    }

    private Date getTokkenExpirationTime() {
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(calendar.MINUTE,EXPIRATION_TIME);
        return new Date(calendar.getTime().getTime());


    }
    public VerificationToken(String tokken){
        super();
        this.tokken=tokken;

        this.expirationTime=this.getTokkenExpirationTime();
    }


}
