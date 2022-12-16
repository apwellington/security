package com.example.scuritye.repository;

import com.example.scuritye.model.Authority;
import com.example.scuritye.util.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByName(AuthorityName name);
}
