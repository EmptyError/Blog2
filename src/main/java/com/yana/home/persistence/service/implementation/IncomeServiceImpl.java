package com.yana.home.persistence.service.implementation;

import com.yana.home.persistence.domain.Account;
import com.yana.home.persistence.domain.Income;
import com.yana.home.persistence.domain.User;
import com.yana.home.persistence.repository.IncomeRepo;
import com.yana.home.persistence.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Admin on 16.05.2017.
 */
@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private IncomeRepo incomeRepo;

    @Override
    public void add(String description,double amount, String date, Account accountTo,User user) {
Income income=new Income();
income.setDescription(description);
income.setAmount(amount);
        System.out.println(date);
String [] dateArray=date.split("-");
        Calendar calendar= new GregorianCalendar(Integer.parseInt(dateArray[0]),Integer.parseInt(dateArray[1]),Integer.parseInt(dateArray[2]));
        System.out.println(calendar.getTime());
income.setDate(calendar.getTime());
income.setAccountTo(accountTo);
income.setUser(user);
incomeRepo.save(income);

    }


//    @Override
//    public void add(Income income) {
//        incomeRepo.save(income);
//    }
//
//    @Override
//    public void addDate(String date,Income income) {
//        String [] dateArray=date.split("-");
//       Calendar calendar= new GregorianCalendar(Integer.parseInt(dateArray[0]),Integer.parseInt(dateArray[1]),Integer.parseInt(dateArray[2]));
//income.setDate(calendar.getTime());
//incomeRepo.save(income);
//    }

    @Override
    public List<Income> findAllByUser(User user) {
        return incomeRepo.findAllByUserOrderByDateAsc(user);
    }

    @Override
    public double findSumIncomes(User user) {
        if(incomeRepo.findAllByUserOrderByDateAsc(user).size()>0) {
            return incomeRepo.findSumIncomes(user);
        }
        else return 0;
    }

    @Override
    public List<Income> findAll() {
        return incomeRepo.findAll();
    }
}
