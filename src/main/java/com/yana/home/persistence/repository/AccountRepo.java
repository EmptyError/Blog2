package com.yana.home.persistence.repository;

import com.yana.home.persistence.domain.Account;
import com.yana.home.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Admin on 12.05.2017.
 */
public interface AccountRepo extends JpaRepository<Account,Integer> {
    List<Account> findByUser(User user);
    @Query("select sum(a.amount) from Account a where a.user=?1 ")
    public double balanceAccounts(User user);
}
