package com.yana.home.persistence.repository;

import com.yana.home.persistence.domain.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Admin on 12.05.2017.
 */
public interface IncomeRepo extends JpaRepository<Income,Integer> {
    @Query(value = "select  sum(i.amount) from  Income i")
    public double findSumIncomes();
}
