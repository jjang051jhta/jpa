package com.jjang051.question.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;


@Entity
@Getter
public class Member {
    @Id
    private Long id;

    private String userId;
    private String password;
    private String email;
    private LocalDateTime regDate;

}
