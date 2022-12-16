package com.example.scuritye.util;

import com.example.scuritye.model.Authority;
import com.example.scuritye.model.User;
import com.example.scuritye.repository.AuthorityRepository;
import com.example.scuritye.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Runner implements CommandLineRunner {


    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.authorityRepository.count() == 0){
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE)
            ));
        }

        if(this.userRepository.count() == 0){
            this.userRepository.saveAll(List.of(
                    new User("wete", new BCryptPasswordEncoder().encode("1234"), List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("wete01", new BCryptPasswordEncoder().encode("1234"), List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get())),
                    new User("wete02", new BCryptPasswordEncoder().encode("1234"), List.of(this.authorityRepository.findByName(AuthorityName.READ).get()))
            ));
        }
    }
}
