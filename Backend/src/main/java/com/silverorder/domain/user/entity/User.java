package com.silverorder.domain.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="T_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID",nullable = false)
    private Long id;

    @Column(name = "USER_EMAIL", length = 30, unique = true,nullable = false)
    @NotNull
    private String userEmail;

    @Column(name = "USER_PW", length = 200,nullable = false)
    @NotNull
    private String userPassword;

    @Column(name = "USER_STATUS",nullable = false)
    @NotNull
    private int userStatus;

    @Column(name = "USER_JOIN_DATE",nullable = false)
    private LocalDateTime userJoinDate;

    @Column(name = "USER_UPDATE_DATE",nullable = false)
    private LocalDateTime userUpdateDate;
}
