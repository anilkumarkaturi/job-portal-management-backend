package com.job_portal.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Table(name = "users")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "email")
    private String email;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "password")
    private String password;

    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToOne
    @JoinColumn(name = "user_type", referencedColumnName = "user_type_id")
    private UserType userTypeId;

//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

}
