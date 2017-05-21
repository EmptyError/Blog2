package com.yana.home.persistence.repository;

import com.yana.home.persistence.domain.Category;
import com.yana.home.persistence.domain.Spending;
import com.yana.home.persistence.domain.User;
import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Admin on 12.05.2017.
 */
public interface SpendingRepo extends JpaRepository<Spending,Integer> {
    List<Spending>findAllByCategoryAndUser(Category category, User user);
    @Query("select sum(s.amount)  from Spending  s where  s.user=?1")
    public  double sumAllSpendingsForUser( User user);

    List<Spending> findAllByUser(User user);
}
