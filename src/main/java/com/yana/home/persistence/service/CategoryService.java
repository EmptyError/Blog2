package com.yana.home.persistence.service;

import com.yana.home.persistence.domain.Category;
import com.yana.home.persistence.domain.Currency;
import com.yana.home.persistence.domain.User;

import java.util.List;

/**
 * Created by Admin on 14.05.2017.
 */
public interface CategoryService {
    public  void  add(Category category);
    public  void delete(int id);
    public void edit(Category category);
public List<Category> findAllByUser(User user);
    public List<Category> findAll();
    public Category findOne(int id);
}
