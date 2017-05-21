package com.yana.home.persistence.repository;

import com.yana.home.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Admin on 11.05.2017.
 */
public interface UserRepo extends JpaRepository<User,Integer> {
User findByLogin(String login);


}
