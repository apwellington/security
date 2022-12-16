package com.example.scuritye.security;

import com.example.scuritye.model.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;

    @Override
    public String getAuthority() {
        return this.authority.getName().name();
    }
}
