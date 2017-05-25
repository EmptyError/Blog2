package com.yana.home.persistence.service;

import com.yana.home.persistence.domain.Account;
import com.yana.home.persistence.domain.Income;
import com.yana.home.persistence.domain.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 16.05.2017.
 */
public interface IncomeService {
    public  void add(String description,double amount, String date, Account accountTo,User user);
    public double findSumIncomes(User user);
    public List<Income> findAll();
    public List<Income>findAllByUser(User user);
}
