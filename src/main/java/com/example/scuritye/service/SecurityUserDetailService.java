package com.example.scuritye.service;

import com.example.scuritye.repository.UserRepository;
import com.example.scuritye.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SecurityUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = this.userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return new SecurityUser(user.get());
    }
}
