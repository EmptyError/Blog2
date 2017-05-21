package com.yana.home.persistence.service.implementation;

import com.yana.home.persistence.domain.Account;
import com.yana.home.persistence.domain.Income;
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
    public void add(String description,double amount, String date, Account accountTo) {
Income income=new Income();
income.setDescription(description);
income.setAmount(amount);
String [] dateArray=date.split("-");
        Calendar calendar= new GregorianCalendar(Integer.parseInt(dateArray[0]),Integer.parseInt(dateArray[1]),Integer.parseInt(dateArray[2]));
income.setDate(calendar.getTime());
income.setAccountTo(accountTo);
incomeRepo.save(income);

    }

    @Override
    public double findSumIncomes() {
        if(incomeRepo.findAll().size()>0) {
            return incomeRepo.findSumIncomes();
        }
        else return 0;
    }

    @Override
    public List<Income> findAll() {
        return incomeRepo.findAll();
    }
}
