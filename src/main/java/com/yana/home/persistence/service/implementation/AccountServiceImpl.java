package com.yana.home.persistence.service.implementation;

import com.yana.home.persistence.domain.Account;
import com.yana.home.persistence.domain.User;
import com.yana.home.persistence.repository.AccountRepo;
import com.yana.home.persistence.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 12.05.2017.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Override
    public void add(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void delete(int id) {
accountRepo.delete(id);
    }

    @Override
    public void edit(Account account) {
accountRepo.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }


    @Override
    public Account findOne(int id) {
        return accountRepo.findOne(id);
    }

    @Override
    public double balanceAccount(User user) {
        if(accountRepo.findByUser(user).size()>0) {
            return accountRepo.balanceAccounts(user);
        }
        else return 0;
    }

    @Override
    public List<Account> findByUser(User user) {
        return accountRepo.findByUser(user);
    }
}
