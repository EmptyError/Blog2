package com.yana.home.persistence.service;


import com.yana.home.persistence.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Admin on 12.05.2017.
 */
public interface UserService {
    public  void  add(User user);
    public  void delete(int id);
    public void edit(User user);
    public User findByLogin(String login);
    public List<User> findAll();
    public void addPhoto(MultipartFile photo,User user);
    public  void activate(String activationKey);
    public  User findByActivationKey(String activationKey);
}
