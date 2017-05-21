package com.yana.home.persistence.service;

import com.yana.home.persistence.domain.Account;
import com.yana.home.persistence.domain.Income;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 16.05.2017.
 */
public interface IncomeService {
    public  void add(String description,double amount, String date, Account accountTo);
    public double findSumIncomes();
    public List<Income> findAll();
}
