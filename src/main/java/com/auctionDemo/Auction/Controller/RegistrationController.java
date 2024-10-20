package com.auctionDemo.Auction.Controller;

import Registraton.RegistrationRequest;
import Service.UserService;
import com.auctionDemo.Auction.Entities.User;
import com.auctionDemo.Auction.Events.RegistrationCompleteEvent;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;
    private ApplicationEventPublisher publisher;

    @PostMapping
    public String registerUser
            (RegistrationRequest registrationRequest,
             final HttpServletRequest request)
    {
        User user=userService.registerUser(registrationRequest);

        //send email validation
        publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));


        return "check ur email to complete for validation ";
    }

    public  String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+
                ":" +
                request.getServerPort()+request.getContextPath();

    }


}
