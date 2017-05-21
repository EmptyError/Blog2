package com.yana.home.persistence.service.implementation;

import com.yana.home.persistence.domain.Account;
import com.yana.home.persistence.domain.User;
import com.yana.home.persistence.repository.UserRepo;
import com.yana.home.persistence.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 12.05.2017.
 */
@Service
public class UserServiceImpl implements UserService,UserDetailsService {
    @Override
    public void addPhoto(MultipartFile multipartFile,User user) {

        double namePhoto=Math.random()*5000;
        File file=new File("C:\\Users\\Admin\\IdeaProjects\\Blog2\\src\\main\\webapp\\resources\\img\\"+namePhoto+"."+multipartFile.getContentType().split("/")[1]);
        try {
            file.createNewFile();
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setPathToPhoto(namePhoto+"."+multipartFile.getContentType().split("/")[1]);
        userRepo.save(user);
    }

    @Autowired
private UserRepo userRepo;


    @Override
    public void add(User user) {
        userRepo.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    public void delete(int id) {
        userRepo.delete(id);

    }

    @Override
    public void edit(User user) {
        userRepo.save(user);

    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user=userRepo.findByLogin(login);
        List<GrantedAuthority> authorities= new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return  new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),authorities);
    }
}
