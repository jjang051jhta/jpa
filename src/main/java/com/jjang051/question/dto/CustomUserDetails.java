package com.jjang051.question.dto;

import com.jjang051.question.entity.Member;
import com.jjang051.question.repository.MemberRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;



@RequiredArgsConstructor
@Getter
public class CustomUserDetails implements UserDetails {
    private final Member loggedMember;

//    public CustomUserDetails(Member loggedMember) {
//        this.loggedMember = loggedMember;
//        //나머지 정보들을 loggedMember가 가지게 된다.
//    }
    //"jjang051",loggedMEmber.userName"장성호"

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_USER";
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return loggedMember.getPassword();
    }

    @Override
    public String getUsername() {
        return loggedMember.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
