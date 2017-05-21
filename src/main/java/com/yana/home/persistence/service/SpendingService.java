package com.yana.home.persistence.service;

import com.yana.home.persistence.domain.Account;
import com.yana.home.persistence.domain.Category;
import com.yana.home.persistence.domain.Spending;
import com.yana.home.persistence.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 19.05.2017.
 */
public interface SpendingService {
    public void add(String description, double amount, String date, Category category, Account accountFrom, User user);
    public List<Spending>findAllForCategoryAndUser(Category category, User user);
    public double sumAllSpendingsForUser(User user);
    public List<Spending > findAllByUser(User user);
}
