package com.yana.home.persistence.repository;

import com.yana.home.persistence.domain.Category;
import com.yana.home.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Admin on 12.05.2017.
 */
public interface CategoryRepo extends JpaRepository<Category,Integer> {
    List<Category> findAllByUser(User user);
}
