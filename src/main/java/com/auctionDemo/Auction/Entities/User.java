package com.auctionDemo.Auction.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;


@Entity
@Data
@Table(name ="App_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long  id;
    private String UserName;
    private String Firstname;
    private String Lastname;
    public String Role;
    @NaturalId(mutable = true)
    private String email;
    private Integer age;
    private Boolean isEnabled =false;
    private String password;



}
