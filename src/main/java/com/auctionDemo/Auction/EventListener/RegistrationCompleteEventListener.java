package com.auctionDemo.Auction.EventListener;

import Service.UserService;
import com.auctionDemo.Auction.Entities.User;
import com.auctionDemo.Auction.Events.RegistrationCompleteEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>{
private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //1.get newly registerd user
        User theuser=event.getUser();
        //2.create verification tokken
        String verificationTokken= UUID.randomUUID().toString();
        //3.save tokken
        userService.saveUserVerificationToken(theuser,verificationTokken);


        //4.verificationUrl
        String url=event.getApplicationUrl()+
                "/register/verifyEmail?token="
                +verificationTokken;
        //5.send email
        log.info("click the link to verify ypur registration:{}",url);

    }
}
