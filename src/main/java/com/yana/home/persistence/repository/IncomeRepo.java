package com.yana.home.persistence.repository;

import com.yana.home.persistence.domain.Income;
import com.yana.home.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Admin on 12.05.2017.
 */
public interface IncomeRepo extends JpaRepository<Income,Integer> {
    @Query(value = "select  sum(i.amount) from  Income i where i.user=?1")
    public double findSumIncomes(User user);
    public List<Income> findAllByUser(User user);
}
