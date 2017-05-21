package com.yana.home.persistence.service;

import com.yana.home.persistence.domain.Account;
import com.yana.home.persistence.domain.User;

import java.util.List;

/**
 * Created by Admin on 12.05.2017.
 */
public interface AccountService  {
    public  void  add(Account account);
    public  void delete(int id);
    public void edit(Account account);
    public List<Account> findAll();
    public  List<Account>findByUser(User user);
    Account findOne(int id);
}
