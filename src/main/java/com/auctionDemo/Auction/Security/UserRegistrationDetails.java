package com.auctionDemo.Auction.Security;

import com.auctionDemo.Auction.Entities.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Data
public class UserRegistrationDetails implements UserDetails {
    private String email;
    private String userNmae;
    private String password;
    private boolean isEnabled;
    private List<GrantedAuthority> authorities;

    public UserRegistrationDetails (User user){
        this.userNmae=user.getUserName();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.isEnabled= user.getIsEnabled();
        this.authorities = Stream.of(user.getRole().split(","))
                .map(String::trim) // Add trimming to remove leading/trailing spaces
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());



    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userNmae;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true ;
    }
    @Override
    public boolean isEnabled(){
        return isEnabled;
    }
}
