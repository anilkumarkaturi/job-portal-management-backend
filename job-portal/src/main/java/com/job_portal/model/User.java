package com.job_portal.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Table(name = "users")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_account_id")
    private String email;

    @Column(name = "user_account_id")
    private Boolean isActive;

    @Column(name = "user_account_id")
    private String password;

    @Column(name = "user_account_id")
    private Date registrationDate;

    @Column(name = "user_account_id")
    private Integer userTypeId;

}
