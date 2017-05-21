package com.yana.home.persistence.service.implementation;

import com.yana.home.persistence.domain.Account;
import com.yana.home.persistence.domain.Category;
import com.yana.home.persistence.domain.Spending;
import com.yana.home.persistence.domain.User;
import com.yana.home.persistence.repository.SpendingRepo;
import com.yana.home.persistence.service.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Admin on 19.05.2017.
 */
@Service
public class SpendingServiceImpl implements SpendingService {
    @Autowired
    private SpendingRepo spendingRepo;

    @Override
    public List<Spending> findAllForCategoryAndUser(Category category, User user) {
        return spendingRepo.findAllByCategoryAndUser(category,user);
    }

    @Override
    public double sumAllSpendingsForUser(User user) {
        if(spendingRepo.findAllByUser(user).size()>0) {
            return spendingRepo.sumAllSpendingsForUser(user);
        }
        else return 0;
    }

    @Override
    public List<Spending> findAllByUser(User user) {
        return spendingRepo.findAllByUser(user);
    }

    @Override
    public void add(String description, double amount,String date, Category category, Account accountFrom, User user) {
        Spending spending= new Spending();
        spending.setDescription(description);
        spending.setAmount(amount);
        String [] dateArray=date.split("-");
        Calendar calendar= new GregorianCalendar(Integer.parseInt(dateArray[0]),Integer.parseInt(dateArray[1]),Integer.parseInt(dateArray[2]));
spending.setDate(calendar.getTime());
spending.setCategory(category);
spending.setAccountFrom(accountFrom);
spending.setUser(user);
spendingRepo.save(spending);
    }
}
