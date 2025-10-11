package com.zaheer.springsecurity.repo;

import com.zaheer.springsecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// using repo for crud
@Repository
public interface userepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
