package com.yana.home.persistence.service.implementation;

import com.yana.home.persistence.domain.Category;
import com.yana.home.persistence.domain.User;
import com.yana.home.persistence.repository.CategoryRepo;
import com.yana.home.persistence.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 14.05.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public void add(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepo.delete( id);
    }

    @Override
    public void edit(Category category) {
categoryRepo.save(category);
    }

    @Override
    public List<Category> findAllByUser(User user) {
        return categoryRepo.findAllByUser(user);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findOne(int id) {
        return categoryRepo.findOne(id);
    }
}
